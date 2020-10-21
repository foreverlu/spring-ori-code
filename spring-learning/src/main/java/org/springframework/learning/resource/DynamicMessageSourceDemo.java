package org.springframework.learning.resource;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author caoweiwei
 * @date 2020/10/15  9:15 下午
 * <p>
 * 动态监听配置文件的变动，实现动态MessageSource
 * 1. 定位资源位置
 * 2. 初始化properties
 * 3. 实现resolveCode方法
 * 4. 文件监听  @see WatchService
 */
public class DynamicMessageSourceDemo extends AbstractMessageSource implements ResourceLoaderAware {

	private static final String FILE_NAME = "messages.properties";

	private static final String RESOURCE_PATH = "/META-INF/i18n/" + FILE_NAME;

	private static final String ENCODE = "UTF-8";

	private ResourceLoader resourceLoader;

	private final Properties properties;

	private final Resource messagePropertiesResource;

	private final ExecutorService executorService = Executors.newSingleThreadExecutor();

	public DynamicMessageSourceDemo() {
		this.messagePropertiesResource = getMessagePropertiesSource();
		this.properties = loadProperties();
		onMessagePropertiesChanged();

	}

	private void onMessagePropertiesChanged() {
		try {
			File messagePropertiesSourceFile = messagePropertiesResource.getFile();
			Path messagePropertiesSourcePath = messagePropertiesSourceFile.toPath();

			FileSystem fileSystem = FileSystems.getDefault();
			WatchService watchService = fileSystem.newWatchService();
			Path dir = messagePropertiesSourcePath.getParent();
			dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
			executorService.submit(()->{
				processMessagePropertiesChanged(watchService);
			});
		} catch (IOException e) {
			throw new RuntimeException();
		}



	}

	private void processMessagePropertiesChanged(WatchService watchService) {
		while (true){
			WatchKey watchKey = null;
			try {
				watchKey = watchService.take();
				if(watchKey.isValid()){
					Path dir = (Path) watchKey.watchable();
					for (WatchEvent<?> event : watchKey.pollEvents()) {
						Path absolutePath = dir.resolve((Path)event.context());
						if("messages.properties".equals(absolutePath.getFileName().toString())){
							System.out.println("文件变化" + absolutePath.toString());
							File file = absolutePath.toFile();
							Properties newProperties =  loadProperties(new FileReader(file));
							synchronized (properties){
								properties.clear();
								properties.putAll(newProperties);
							}
						}
					}

				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}finally {
				if(null!=watchKey){
					watchKey.reset();
				}

			}
		}
	}

	private Properties loadProperties() {

		EncodedResource encodedResource = new EncodedResource(messagePropertiesResource, ENCODE);
		try {
			return loadProperties(encodedResource.getReader());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Resource getMessagePropertiesSource() {
		return getResourceLoader().getResource(RESOURCE_PATH);
	}

	private Properties loadProperties(Reader reader) {
		Properties properties = new Properties();
		try {
			properties.load(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return properties;
	}


	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		String messageFormatPattern = properties.getProperty(code);
		if (StringUtils.hasText(messageFormatPattern)) {
			return new MessageFormat(messageFormatPattern, locale);
		}
		return null;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public ResourceLoader getResourceLoader() {
		return this.resourceLoader != null ? this.resourceLoader : new DefaultResourceLoader();
	}

	public static void main(String[] args) throws InterruptedException {
		DynamicMessageSourceDemo demo = new DynamicMessageSourceDemo();
		for(int i=0;i<10000;i++){
			String message = demo.getMessage("name", null, Locale.getDefault());
			System.out.println(message);
			Thread.sleep(1000);
		}

	}
}

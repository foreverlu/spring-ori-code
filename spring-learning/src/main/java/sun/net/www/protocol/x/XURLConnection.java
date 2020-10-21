package sun.net.www.protocol.x;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author caoweiwei
 * @date 2020/10/14  9:55 上午
 */
public class XURLConnection extends URLConnection {

	final ClassPathResource resource;
	/**
	 * Constructs a URL connection to the specified URL. A connection to
	 * the object referenced by the URL is not created.
	 *
	 * @param url the specified URL.
	 */
	protected XURLConnection(URL url) {
		super(url);
		resource = new ClassPathResource(url.getPath());
	}

	@Override
	public void connect() throws IOException {

	}

	@Override
	public InputStream getInputStream() throws IOException {
		return resource.getInputStream();
	}
}

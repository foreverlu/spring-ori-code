package org.springframework.learning.resource;

import org.springframework.util.StreamUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author caoweiwei
 * @date 2020/10/14  5:37 下午
 */
public class HttpUrlFileDownloadDemo {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1602678457321&di=d26ccbd9d275d3bcb3569e8f5e241c03&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201512%2F22%2F20151222223118_tnvcX.thumb.700_0.jpeg");
		InputStream inputStream = url.openStream();

		FileOutputStream out = new FileOutputStream("/Users/cao/x.jpg");
		StreamUtils.copy(inputStream,out);
	}
}

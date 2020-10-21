package sun.net.www.protocol.x;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author caoweiwei
 * @date 2020/10/14  9:59 上午
 */
public class URLStreamHandlerTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("x:///META-INF/user.properties");
		InputStream inputStream = url.openStream();
		System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("utf-8")));
		System.out.println(url.getProtocol());
	}
}

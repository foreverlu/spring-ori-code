package org.springframework.learning.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author caoweiwei
 * @date 2020/10/15  9:45 上午
 */
public class ResourceBundleDemo {

	public static void main(String[] args) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("my",new Locale("zh","CN"));
		String cancelKey = resourceBundle.getString("cancelKey");
		System.out.println(cancelKey);

		resourceBundle = ResourceBundle.getBundle("my", Locale.US);
		System.out.println(resourceBundle.getString("cancelKey"));
	}
}

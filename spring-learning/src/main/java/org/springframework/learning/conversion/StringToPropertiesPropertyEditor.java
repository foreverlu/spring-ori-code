package org.springframework.learning.conversion;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * @author caoweiwei
 * @date 2020/10/21  9:31 上午
 */
public class StringToPropertiesPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Properties properties = new Properties();
		StringReader reader = new StringReader(text);

		try {
			properties.load(reader);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		setValue(properties);
	}

	@Override
	public String getAsText() {
		Properties value = (Properties)getValue();
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Object, Object> entry : value.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append(System.lineSeparator());
		}

		return sb.toString();
	}
}

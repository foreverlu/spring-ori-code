package org.springframework.learning.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author caoweiwei
 * @date 2020/10/26  9:46 上午
 */
public class PropertiesToStringConverter implements ConditionalGenericConverter {
	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return Properties.class.equals(sourceType.getObjectType())
				&& String.class.equals(targetType.getObjectType());
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(Properties.class, String.class));
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Properties value = (Properties) source;
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Object, Object> entry : value.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append(System.lineSeparator());
		}

		return sb.toString();
	}
}

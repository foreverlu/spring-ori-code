package org.springframework.learning.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * @author caoweiwei
 * @date 2020/10/21  1:48 下午
 */
public class ConvertorDemo {


	class TimeStampToLocalDateTimeConvertor implements ConditionalGenericConverter {

		@Override
		public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
			return true;
		}

		@Override
		public Set<ConvertiblePair> getConvertibleTypes() {
			return Collections.singleton(new ConvertiblePair(Long.class, LocalDateTime.class));
		}

		@Override
		public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

			return Instant.ofEpochMilli((Long)source).atZone(TimeZone.getDefault().toZoneId()).toLocalDateTime();
		}
	}
}

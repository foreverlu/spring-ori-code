package org.springframework.learning.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.Reader;

/**
 * @author caoweiwei
 * @date 2020/10/13  8:35 下午
 */
public class PathMatchingResourcePatternResolverDemo {
	public static void main(String[] args) {
		String currentJavaPath = System.getProperty("user.dir")+"/spring-learning/src/main/java/org/springframework/learning/resource/*.java";
		File currentJavaFile = new File(currentJavaPath);

		PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourcePatternResolver.getResource(currentJavaPath);
	}
}

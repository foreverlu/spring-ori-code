package org.springframework.learning.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.*;

/**
 * @author caoweiwei
 * @date 2020/10/13  7:47 下午
 * @see org.springframework.core.io.support.EncodedResource
 * @see org.springframework.core.io.FileSystemResource
 * 编码
 */
public class EncodedFileSystemResourceDemo {

	public static void main(String[] args) throws IOException {
		String currentJavaPath = System.getProperty("user.dir")+"/spring-learning/src/main/java/org/springframework/learning/resource/EncodedFileSystemResourceDemo.java";
		File currentJavaFile = new File(currentJavaPath);
		FileSystemResource resource = new FileSystemResource(currentJavaFile);

		EncodedResource encodedResource = new EncodedResource(resource,"utf-8");
		Reader reader = encodedResource.getReader();
		String str = IOUtils.toString(reader);
		System.out.println(str);
	}
}

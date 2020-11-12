package org.springframework.learning.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author caoweiwei
 * @date 2020/11/12  9:35 上午
 */
public class ValueAnnotationDemo {

	@Value("${user.name}")
	private String userName;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.refresh();
		context.register(ValueAnnotationDemo.class);

//		ConfigurableEnvironment environment = context.getEnvironment();
//		String userName = environment.getProperty("userName");
//		System.out.println(userName);

		ValueAnnotationDemo demo = context.getBean(ValueAnnotationDemo.class);
		System.out.println(demo.userName);


		context.close();

	}
}

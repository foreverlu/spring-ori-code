package org.springframework.learning.initialization;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learning.domain.User;

/**
 * @author caoweiwei
 * @date 2020/9/30  10:16 上午
 * spring bean 初始化
 */
public class SpringBeanInitializationDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-dependency-lookup.xml");
		initMethodInitialization(beanFactory);
	}

	private static void initMethodInitialization(BeanFactory beanFactory) {
		User user = beanFactory.getBean("user", User.class);
		System.out.println(user);
	}
}

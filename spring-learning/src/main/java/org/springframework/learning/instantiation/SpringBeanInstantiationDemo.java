package org.springframework.learning.instantiation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learning.domain.DefaultUserFactory;
import org.springframework.learning.domain.User;
import org.springframework.learning.domain.UserFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author caoweiwei
 * @date 2020/9/29  5:31 下午
 * Spring bean的实例化的集中方式
 */
public class SpringBeanInstantiationDemo {


	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-dependency-lookup.xml");
		AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

		createByFactoryMethod(beanFactory);
		createByFactory(beanFactory);
		createByFactoryBean(beanFactory);
		createByServiceLoaderFactoryBean(beanFactory);
		
		createByAutowireCapableBeanFactory(beanFactory);
	}

	private static void createByAutowireCapableBeanFactory(AutowireCapableBeanFactory beanFactory) {
		UserFactory factory = beanFactory.createBean(DefaultUserFactory.class);
		System.out.println(factory.createUser());
	}

	private static void createByFactoryMethod(BeanFactory beanFactory) {
		User user = beanFactory.getBean("user-createUser", User.class);
		System.out.println(user);
	}

	private static void createByFactory(BeanFactory beanFactory) {
		User user = beanFactory.getBean("user-factory", User.class);
		System.out.println(user);
	}

	private static void createByFactoryBean(BeanFactory beanFactory) {
		User user = beanFactory.getBean("user-factory-bean", User.class);
		System.out.println(user);
	}

	private static void createByServiceLoaderFactoryBean(BeanFactory beanFactory) {
//		ServiceLoader<UserFactory> bean = beanFactory.getBean(ServiceLoader.class);
//		System.out.println(obj instanceof ServiceLoader);
//		Iterator<UserFactory> iterator = serviceLoader.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next().createUser());
//		}
	}
}

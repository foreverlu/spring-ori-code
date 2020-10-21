package org.springframework.learning.beandefinitiondemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyPathFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learning.domain.User;

/**
 * @author caoweiwei
 * @date 2020/9/30  4:17 下午
 */
public class PropertyBeanDefinitionReaderDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("classpath:/META-INF/user.properties");
		User user = beanFactory.getBean("user", User.class);
		System.out.println(user);

	}
}

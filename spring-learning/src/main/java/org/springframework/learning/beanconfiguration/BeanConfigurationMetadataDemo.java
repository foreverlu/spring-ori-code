package org.springframework.learning.beanconfiguration;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.learning.domain.User;
import org.springframework.util.ObjectUtils;

/**
 * @author caoweiwei
 * @date 2020/10/13  1:25 下午
 * {@link PropertyValue}
 */
public class BeanConfigurationMetadataDemo {
	public static void main(String[] args) {

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		builder.addPropertyValue("name","cew");
		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

		beanDefinition.setSource(BeanConfigurationMetadataDemo.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				if(ObjectUtils.nullSafeEquals("user",beanName) && User.class.equals(bean.getClass())){
					User user = (User)bean;
					user.setAge(100);
				}
				return bean;
			}
		});
		beanFactory.registerBeanDefinition("user",beanDefinition);

		System.out.println(beanFactory.getBean("user", User.class));
	}
}

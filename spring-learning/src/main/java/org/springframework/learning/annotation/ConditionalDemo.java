package org.springframework.learning.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author caoweiwei
 * @date 2020/11/11  9:55 上午
 */
@Configuration
public class ConditionalDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ConditionalDemo.class);

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		environment.setActiveProfiles("odd");
		applicationContext.refresh();

		Integer number = applicationContext.getBean("number", Integer.class);
		System.out.println(number);

		applicationContext.close();

	}

	@Bean("number")
	@Conditional(OddCondition.class)
	public Integer odd(){
		return 1;
	}
}

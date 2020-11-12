package org.springframework.learning.springevent.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author caoweiwei
 * @date 2020/11/6  11:09 上午
 */
public class Demo {



	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext();
		applicationContext.register(Demo.class);
//		applicationContext.addApplicationListener(new BlockedListNotifier());

		applicationContext.refresh();
		EmailService emailService = applicationContext.getBean("emailService", EmailService.class);
		emailService.event("wwwwwwwwwww");

		applicationContext.close();
	}


	@Bean
	public EmailService emailService(){
		return new EmailService();
	}

	@Bean
	public BlockedListNotifier blockedListNotifier(){
		return new BlockedListNotifier();
	}
}

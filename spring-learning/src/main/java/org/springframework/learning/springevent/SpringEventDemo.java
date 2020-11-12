package org.springframework.learning.springevent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.DefaultEventListenerFactory;
import org.springframework.context.event.EventListenerFactory;

import java.lang.reflect.Method;

/**
 * @author caoweiwei
 * @date 2020/11/5  9:34 上午
 */
//@Configuration
public class SpringEventDemo implements ApplicationContextAware {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.addApplicationListener(new MyEventListener());
		applicationContext.register(SpringEventDemo.class);

		applicationContext.refresh();
		applicationContext.close();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		applicationContext.publishEvent(new MyApplicationEvent("cww"));
	}

	@Bean
	public EventListenerFactory eventListenerFactory(){
		EventListenerFactory factory = new DefaultEventListenerFactory();
		MyEventListener listener = new MyEventListener();
		Method method = null;
		try {
			method = listener.getClass().getDeclaredMethod("onApplicationEvent",MyApplicationEvent.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return factory;
	}



}

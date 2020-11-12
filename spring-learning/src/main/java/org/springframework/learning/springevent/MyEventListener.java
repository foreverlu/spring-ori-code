package org.springframework.learning.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * @author caoweiwei
 * @date 2020/11/5  9:46 上午
 */
public class MyEventListener implements ApplicationListener<MyApplicationEvent> , Serializable {


	private static final long serialVersionUID = -675413831816246165L;

	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("MyApplicationEvent: "+ event.getSource());
	}
}

package org.springframework.learning.springevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

/**
 * @author caoweiwei
 * @date 2020/11/5  9:39 上午
 */
public class MyApplicationEvent extends ApplicationEvent{


	private static final long serialVersionUID = -4328223961215044663L;

	public MyApplicationEvent(String message) {
		super(message);
	}

	/**
	 * Get the {@code ApplicationContext} that the event was raised for.
	 */
	public final String getApplicationContext() {
		return (String) getSource();
	}
}

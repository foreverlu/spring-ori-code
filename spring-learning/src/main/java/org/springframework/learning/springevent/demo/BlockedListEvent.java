package org.springframework.learning.springevent.demo;

import org.springframework.context.ApplicationEvent;

/**
 * @author caoweiwei
 * @date 2020/11/6  11:03 上午
 */
public class BlockedListEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1100221366975829616L;

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public BlockedListEvent(Object source) {
		super(source);
	}
}

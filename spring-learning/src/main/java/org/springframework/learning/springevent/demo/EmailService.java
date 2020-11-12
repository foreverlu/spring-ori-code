package org.springframework.learning.springevent.demo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author caoweiwei
 * @date 2020/11/6  11:04 上午
 */
@Service
public class EmailService implements ApplicationEventPublisherAware {

	ApplicationEventPublisher publisher;

	public void event(String mes){
		publisher.publishEvent(new BlockedListEvent(mes));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;

	}
}

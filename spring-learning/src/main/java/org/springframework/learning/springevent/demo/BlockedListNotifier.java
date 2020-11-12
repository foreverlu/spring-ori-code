package org.springframework.learning.springevent.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author caoweiwei
 * @date 2020/11/6  11:07 上午
 */

@Service
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {
	@Override
	public void onApplicationEvent(BlockedListEvent event) {
		System.out.println(event.getSource());
	}
}

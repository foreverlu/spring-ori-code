package org.springframework.learning.domain;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author caoweiwei
 * @date 2020/9/29  5:46 下午
 */
public class UserFactoryBean implements FactoryBean<User> {
	@Override
	public User getObject() throws Exception {
		return User.createUser();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}

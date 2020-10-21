package org.springframework.learning.domain;

/**
 * @author caoweiwei
 * @date 2020/9/29  5:35 下午
 */
public interface UserFactory {
	default User createUser(){
		User user = new User();
		user.setName("cww-userFactory");
		return user;
	}
}

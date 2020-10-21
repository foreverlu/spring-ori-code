package org.springframework.learning.domain;

import javax.annotation.PostConstruct;

/**
 * @author caoweiwei
 * @date 2020/9/29  4:47 下午
 */
public class User {
	private String name;
	private int age;

	public void init(){
		age = 101;
	}

	@PostConstruct
	public void postConstruct(){
		age = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public static User createUser(){
		User user = new User();
		user.setName("cww-createUser");
		user.setAge(11);
		return user;
	}
}

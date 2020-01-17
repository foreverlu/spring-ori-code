package com.cww.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	IndexService indexService;

	public int i = 0;
	
	public UserService(){
		System.out.println("userService 构造器");
	}
}

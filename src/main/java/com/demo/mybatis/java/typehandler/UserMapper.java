package com.demo.mybatis.java.typehandler;

import java.util.List;


public interface UserMapper {

	List<User> getUserList();
	
	void addUser(User user);
	
}

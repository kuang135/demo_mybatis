package com.demo.mybatis.java.base;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	List<User> getUserList();
	
	@Select("SELECT * FROM USER WHERE ID = #{id}")
	User getUserById(String id);
	
}

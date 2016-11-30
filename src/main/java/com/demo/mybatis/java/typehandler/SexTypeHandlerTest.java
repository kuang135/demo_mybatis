package com.demo.mybatis.java.typehandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class SexTypeHandlerTest {
	
	@Test
	public void getTest() throws IOException {
		// 读取配置文件
		String resource = "java/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//打开SqlSession,true表示自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//执行查询
		//获取动态创建的UserDao的实现(映射器)
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = mapper.getUserList();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void addTest() throws IOException {
		// 读取配置文件
		String resource = "java/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//打开SqlSession,true表示自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//执行查询
		//获取动态创建的UserDao的实现(映射器)
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User("9","jj","swift","男");
		mapper.addUser(user);
	}

}

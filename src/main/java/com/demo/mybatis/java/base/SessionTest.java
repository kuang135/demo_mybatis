package com.demo.mybatis.java.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class SessionTest {
	
	@Test
	public void selectOneTest() throws IOException {
		// 读取配置文件
		String resource = "java/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//打开SqlSession,true表示自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//执行查询
		User user = sqlSession.selectOne("myNamespace.getUserByName", "科比");//namespace+"."+id
		System.out.println(user);
	}
	
	@Test
	public void selectListTest() throws IOException {
		// 读取配置文件
		String resource = "java/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//打开SqlSession,true表示自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//执行查询
		List<User> list = sqlSession.selectList("myNamespace.getUserList");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void selectMapTest() throws IOException {
		// 读取配置文件
		String resource = "java/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//打开SqlSession,true表示自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//执行查询
		Map<Object, Object> map = sqlSession.selectMap("myNamespace.getUserMap","id");
		Set<Entry<Object, Object>> set = map.entrySet();
		for (Entry<Object, Object> entry : set) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}

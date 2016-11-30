package com.demo.mybatis.java.interceptor;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class InterceptorTest {

	@Test
	public void CamHumpInterceptorTest() throws IOException {
		// 读取配置文件
		String resource = "java/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//打开SqlSession,true表示自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//执行查询
		//获取动态创建的UserDao的实现(映射器)
		PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
		List<Map<String,Object>> list = mapper.getMapList();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		//未拦截：{NOW_TEAM=GS, NAME=库里, MAX_SCORE=38, ID=2, AVG_SCORE=28}
		//拦截：{id=2, maxScore=38, avgScore=28, nowTeam=GS, name=库里}
	}
	
}

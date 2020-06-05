package com.briup.estore.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionUtil {

	private static SqlSessionFactory ssf;
	
	static {
		try {
			InputStream is = 
					Resources.getResourceAsStream("mybatis-config.xml");

			ssf = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	public static SqlSession getSqlSession() {
		return getSqlSession(false);
	}
	
	public static SqlSession getSqlSession(boolean auto) {
		return ssf.openSession(auto);
	} 
}

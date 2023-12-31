package com.game.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.mapper.CookieInfoMapper;
import com.game.vo.CookieInfoVO;
import com.game.vo.ValoInfoVO;

public class MybatisSqlSessionFactory {
	
	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";
	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH); // 경로 가져오기. InputStream은 batis 단위로 끊어서 읽도록 함
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder(); // 공장을 만들어내는 아이
			SSF = ssfb.build(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}
	
	public static void main(String[] args) {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		CookieInfoMapper ciMapper = session.getMapper(CookieInfoMapper.class);
		List<CookieInfoVO> cookies = ciMapper.selectCookieInfoList(null);
		CookieInfoVO cookie = ciMapper.selectCookieInfo("4");
		System.out.println(cookie);
	}
}

package com.game.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.CookieInfoMapper;
import com.game.service.CookieInfoService;
import com.game.vo.CookieInfoVO;

public class CookieInfoServiceImpl implements CookieInfoService {
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<CookieInfoVO> getCookieInfoList(CookieInfoVO cookie) {
		try(SqlSession session = ssf.openSession()){
			CookieInfoMapper ciMapper = session.getMapper(CookieInfoMapper.class);
			return ciMapper.selectCookieInfoList(cookie);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public CookieInfoVO getCookieInfo(String ciNum) {
		try(SqlSession session = ssf.openSession()){
			CookieInfoMapper ciMapper = session.getMapper(CookieInfoMapper.class);
			return ciMapper.selectCookieInfo(ciNum);
		}catch(Exception e) {
			throw e;
		}
	}

}

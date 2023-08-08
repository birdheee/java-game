package com.game.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.ValoInfoMapper;
import com.game.service.ValoInfoService;
import com.game.vo.ValoInfoVO;

public class ValoInfoServiceImpl implements ValoInfoService {
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<ValoInfoVO> selectValoInfoList(ValoInfoVO valo) {
		try(SqlSession session = ssf.openSession()){
			ValoInfoMapper viMapper = session.getMapper(ValoInfoMapper.class);
			return viMapper.selectValoInfoList(valo);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public ValoInfoVO selectValoInfo(String viNum) {
		try(SqlSession session = ssf.openSession()){
			ValoInfoMapper viMapper = session.getMapper(ValoInfoMapper.class);
			return viMapper.selectValoInfo(viNum);
		}catch(Exception e) {
			throw e;
		}
	}

}

package com.game.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.LectureInfoMapper;
import com.game.service.LectureInfoService;
import com.game.vo.LectureInfoVO;

public class LectureInfoServiceImpl implements LectureInfoService {
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<LectureInfoVO> getLectureInfoList(LectureInfoVO lecture) {
		try(SqlSession session = ssf.openSession()){
			LectureInfoMapper liMapper = session.getMapper(LectureInfoMapper.class);
			return liMapper.selectLectureInfoList(lecture);
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public LectureInfoVO getLectureInfo(String liNum) {
		try(SqlSession session = ssf.openSession()){
			LectureInfoMapper liMapper = session.getMapper(LectureInfoMapper.class);
			return liMapper.selectLectureInfo(liNum);
		}catch(Exception e) {
			throw e;
		}
	}

}

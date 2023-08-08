package com.game.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.BoardInfoDao;
import com.game.dao.impl.BoardInfoDaoImpl;
import com.game.mapper.BoardInfoMapper;
import com.game.service.BoardInfoService;
import com.game.vo.BoardInfoVO;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoDao boardInfoDao = new BoardInfoDaoImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfoList(board);
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public BoardInfoVO selectBoardInfo(String biNum) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfo(biNum);
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		return boardInfoDao.insertBoardInfo(board);
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		return boardInfoDao.updateBoardInfo(board);
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		return boardInfoDao.deleteBoardInfo(biNum);
	}

}

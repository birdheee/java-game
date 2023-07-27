package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.BoardInfoDao;
import com.game.dao.impl.BoardInfoDaoImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoDao boardInfoDao = new BoardInfoDaoImpl();
	
	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		return boardInfoDao.selectBoardInfoList(board);
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		return boardInfoDao.selectBoardInfo(biNum);
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

package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.BoardInfoDao;
import com.game.dao.impl.BoardInfoDaoImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	BoardInfoDao biDao = new BoardInfoDaoImpl();

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		return biDao.selectBoardInfoList(boardInfo);
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		return biDao.selectBoardInfo(biNum);
	}

	@Override
	public int insertBoardInfo(Map<String, String> boardInfo) {
		return biDao.insertBoardInfo(boardInfo);
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		return biDao.updateBoardInfo(boardInfo);
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		return biDao.deleteBoardInfo(biNum);
	}

}

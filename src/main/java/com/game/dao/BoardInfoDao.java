package com.game.dao;

import java.util.List;
import java.util.Map;

public interface BoardInfoDao {
	List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo);
	Map<String, String> selectBoardInfo(String biNum);
	int insertBoardInfo(Map<String, String> boardInfo);
	int updateBoardInfo(Map<String, String> boardInfo);
	int deleteBoardInfo(String biNum);
}
package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.BoardInfoVO;

public interface BoardInfoService {
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board);
	Map<String, String> selectBoardInfo(String biNum);
	int insertBoardInfo(Map<String, String> board);
	int updateBoardInfo(Map<String, String> board);
	int deleteBoardInfo(String biNum);
}
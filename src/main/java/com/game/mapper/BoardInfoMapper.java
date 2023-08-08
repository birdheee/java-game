package com.game.mapper;

import java.util.List;

import com.game.vo.BoardInfoVO;

public interface BoardInfoMapper {
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board);
	BoardInfoVO selectBoardInfo(String biNum);
	int insertBoardInfo(BoardInfoVO board);
	int updateBoardInfo(BoardInfoVO board);
	int deleteBoardInfo(BoardInfoVO board);
}
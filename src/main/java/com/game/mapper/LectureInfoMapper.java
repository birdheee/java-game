package com.game.mapper;

import java.util.List;

import com.game.vo.LectureInfoVO;

public interface LectureInfoMapper {
	List<LectureInfoVO> selectLectureInfoList(LectureInfoVO lecture);
	LectureInfoVO selectLectureInfo(String liNum);
}
package com.game.service;

import java.util.List;

import com.game.vo.LectureInfoVO;

public interface LectureInfoService {
	List<LectureInfoVO> getLectureInfoList(LectureInfoVO lecture);
	LectureInfoVO getLectureInfo(String liNum);
}
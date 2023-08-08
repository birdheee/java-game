package com.game.service;

import java.util.List;

import com.game.vo.ValoInfoVO;

public interface ValoInfoService {
	List<ValoInfoVO> selectValoInfoList(ValoInfoVO valo);
	ValoInfoVO selectValoInfo(String viNum);
}

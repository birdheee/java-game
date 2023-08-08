package com.game.mapper;

import java.util.List;

import com.game.vo.ValoInfoVO;

public interface ValoInfoMapper {
	List<ValoInfoVO> selectValoInfoList(ValoInfoVO valo);
	ValoInfoVO selectValoInfo(String viNum);
}
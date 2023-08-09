package com.game.mapper;

import java.util.List;

import com.game.vo.CookieInfoVO;

public interface CookieInfoMapper {
	List<CookieInfoVO> selectCookieInfoList(CookieInfoVO cookie);
	CookieInfoVO selectCookieInfo(String ciNum);
}
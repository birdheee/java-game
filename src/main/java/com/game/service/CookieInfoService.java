package com.game.service;

import java.util.List;

import com.game.vo.CookieInfoVO;

public interface CookieInfoService {
	List<CookieInfoVO> getCookieInfoList(CookieInfoVO cookie);
	CookieInfoVO getCookieInfo(String ciNum);
}

package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.UserInfoDao;
import com.game.dao.impl.UserInfoDaoImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	// 아직은 큰 로직이 없음. 그저 중간다리 역할
	private UserInfoDao uiDao = new UserInfoDaoImpl();

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		return uiDao.selectUserInfoList(userInfo);
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		return uiDao.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		return uiDao.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		return uiDao.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		return uiDao.deleteUserInfo(uiNum);
	}

}

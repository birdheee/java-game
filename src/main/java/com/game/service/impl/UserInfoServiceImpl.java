package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.dao.UserInfoDao;
import com.game.dao.impl.UserInfoDaoImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	// 아직은 큰 로직이 없음. 그저 중간다리 역할
	// ID 유효성 검사 등을 함
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
	
	@Override
	public Map<String, String> login(String uiID) {
		return uiDao.selectUserInfoById(uiID);
	}

//	@Override
//	public boolean login(Map<String, String> userInfo, HttpSession session) {
//		String uiId = userInfo.get("uiId");
//		Map<String, String> tmp = uiDao.selectUserInfoById(uiId);
//		if(tmp!=null) { // 있는 아이디인 경우
//			String uiPwd = tmp.get("uiPwd");
//			if(uiPwd.equals(userInfo.get("uiPwd"))) { // 데이터베이스 비번과 사용자 비번을 비교
//				session.setAttribute("user", tmp);
//				return true; // 로그인 성공 !
//			}
//		}
//		return false;
//	}

}

package com.game.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.vo.UserInfoVO;

public interface UserInfoService {
	List<UserInfoVO> getUserInfoList(UserInfoVO userInfo);
	UserInfoVO getUserInfo(String uiNum);
	int addUserInfo(Map<String,String> userInfo);
	int updateUserInfo(Map<String,String> userInfo);
	int deleteUserInfo(String uiNum);
	boolean login(Map<String,String> userInfo, HttpSession session);
}
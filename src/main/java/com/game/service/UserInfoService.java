package com.game.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.vo.UserInfoVO;

public interface UserInfoService {
	List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo);
	Map<String,String> selectUserInfo(String uiNum);
	int insertUserInfo(Map<String,String> userInfo);
	int updateUserInfo(Map<String,String> userInfo);
	int deleteUserInfo(String uiNum);
	boolean login(Map<String,String> userInfo, HttpSession session);
}
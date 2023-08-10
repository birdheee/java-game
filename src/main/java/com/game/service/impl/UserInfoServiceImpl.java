package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.UserInfoDao;
import com.game.dao.impl.UserInfoDaoImpl;
import com.game.mapper.UserInfoMapper;
import com.game.service.UserInfoService;
import com.game.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDao uiDao = new UserInfoDaoImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<UserInfoVO> getUserInfoList(UserInfoVO userInfo) {
		try(SqlSession session = ssf.openSession()){
			UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
			return userInfoMapper.selectUserInfoList(userInfo);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public UserInfoVO getUserInfo(String uiNum) {
		try(SqlSession session = ssf.openSession()){
			UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
			return userInfoMapper.selectUserInfo(uiNum);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public int addUserInfo(Map<String, String> userInfo) {
		try(SqlSession session = ssf.openSession()){
			UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
			return userInfoMapper.insertUserInfo(userInfo);
		}catch(Exception e) {
			throw e;
		}
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
	public boolean login(Map<String, String> userInfo, HttpSession session) {
		String uiId = userInfo.get("uiId");
		Map<String, String> tmp = uiDao.selectUserInfoById(uiId);
		if(tmp!=null) { // 있는 아이디인 경우
			String uiPwd = tmp.get("uiPwd");
			if(uiPwd.equals(userInfo.get("uiPwd"))) { // 데이터베이스 비번과 사용자 비번을 비교
				session.setAttribute("user", tmp);
				return true; // 로그인 성공 !
			}
		}
		return false;
	}

}

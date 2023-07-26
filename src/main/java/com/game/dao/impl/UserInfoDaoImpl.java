package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.UserInfoDao;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;

public class UserInfoDaoImpl implements UserInfoDao {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC ,\r\n"
				+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO";
		List<Map<String, String>> userInfoList = new ArrayList<>();
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> ui = new HashMap<>();
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("uiId", rs.getString("UI_ID"));
						ui.put("uiPwd", rs.getString("UI_PWD"));
						ui.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						ui.put("uiDesc", rs.getString("UI_DESC"));
						ui.put("uiBirth", rs.getString("UI_BIRTH"));
						ui.put("credat", rs.getString("CREDAT"));
						ui.put("cretim", rs.getString("CRETIM"));
						ui.put("lmodat", rs.getString("LMODAT"));
						ui.put("lmotim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("ACTIVE"));
						userInfoList.add(ui);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC ,\r\n"
				+ "DATE_FORMAT(UI_BIRTH, '%Y-%m-%d') UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> ui = new HashMap<>();
						ui.put("uiNum", rs.getString("UI_NUM"));
						ui.put("uiName", rs.getString("UI_NAME"));
						ui.put("uiId", rs.getString("UI_ID"));
						ui.put("uiPwd", rs.getString("UI_PWD"));
						ui.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						ui.put("uiDesc", rs.getString("UI_DESC"));
						ui.put("uiBirth", rs.getString("UI_BIRTH"));
						ui.put("credat", rs.getString("CREDAT"));
						ui.put("cretim", rs.getString("CRETIM"));
						ui.put("lmodat", rs.getString("LMODAT"));
						ui.put("lmotim", rs.getString("LMOTIM"));
						ui.put("active", rs.getString("ACTIVE"));
						return ui;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql ="INSERT INTO USER_INFO(\r\n"
				+ "UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, \r\n"
				+ "UI_DESC, UI_BIRTH, CREDAT, CRETIM, \r\n"
				+ "LMODAT, LMOTIM)\r\n"
				+ "VALUES(\r\n"
				+ "?,?,?,?,\r\n"
				+ "?,?,DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE USER_INFO\r\n"
				+ "SET UI_NAME=?,\r\n"
				+ "UI_PWD=?,\r\n"
				+ "UI_IMG_PATH=?,\r\n"
				+ "UI_DESC=?,\r\n"
				+ "UI_BIRTH=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiPwd"));
				ps.setString(3, userInfo.get("uiImgPath"));
				ps.setString(4, userInfo.get("uiDesc"));
				ps.setString(5, userInfo.get("uiBirth"));
				ps.setString(6, userInfo.get("uiNum"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiNum);
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Map<String, String> selectUserInfoById(String uiId) {

		String sql ="SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC ,\r\n"
				+ "DATE_FORMAT(UI_BIRTH,'%Y-%m-%d') UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO WHERE UI_ID=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiId);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

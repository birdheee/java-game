package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDao;

public class BoardInfoDaoImpl implements BoardInfoDao {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		List<Map<String, String>> boardInfoList = new ArrayList<>();
		String sql = "SELECT BI.*, UI.UI_NAME FROM BOARD_INFO BI \r\n"
				+ "INNER JOIN USER_INFO UI \r\n"
				+ "ON BI.UI_NUM = UI.UI_NUM WHERE 1=1";
		if(board != null) {
			String key = board.get("key");
			if("1".equals(key)) {
				sql += " AND BI_TITLE LIKE CONCAT('%',?,'%')";
			}else if("2".equals(key)) {
				sql += " AND UI_NAME LIKE CONCAT('%',?,'%')";
			}else if("3".equals(key)) {
				sql += " AND BI_CONTENT LIKE CONCAT('%',?,'%')";
			}else if("4".equals(key)) {
				sql += " AND BI_TITLE LIKE CONCAT('%',?,'%') OR BI_CONTENT LIKE CONCAT('%',?,'%')";
			}else if("5".equals(key)) {
				sql += " AND UI_NAME LIKE CONCAT('%',?,'%') OR BI_CONTENT LIKE CONCAT('%',?,'%')";
			}else if("6".equals(key)) {
				sql += " AND BI_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%')";
			}else if("7".equals(key)) {
				sql += " AND BI_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%') "
						+ "OR BI_CONTENT LIKE CONCAT('%',?,'%')";
			}
		}
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				if(board != null) {
					String key = board.get("key");
					if("1".equals(key) || "2".equals(key) || "3".equals(key)) {
						pstmt.setString(1, board.get("value"));
					}
					
				}
				try(ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						Map<String, String> boardInfo = new HashMap<>();
						boardInfo.put("biNum", rs.getString("BI_NUM"));
						boardInfo.put("biTitle", rs.getString("BI_TITLE"));
						boardInfo.put("biContent", rs.getString("BI_CONTENT"));
						boardInfo.put("uiNum", rs.getString("UI_NUM"));
						boardInfo.put("uiName", rs.getString("UI_NAME"));
						boardInfo.put("credat", rs.getString("CREDAT"));
						boardInfo.put("cretim", rs.getString("CRETIM"));
						boardInfo.put("lmodat", rs.getString("LMODAT"));
						boardInfo.put("lmotim", rs.getString("LMOTIM"));
						boardInfo.put("active", rs.getString("ACTIVE"));
						boardInfoList.add(boardInfo);
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boardInfoList;
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		Map<String, String> boardInfo = new HashMap<>();
		String sql = "SELECT BI_NUM, BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, \r\n"
				+ "LMOTIM, ACTIVE FROM BOARD_INFO WHERE 1=1 AND BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, biNum);
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						boardInfo.put("biNum", rs.getString("BI_NUM"));
						boardInfo.put("biTitle", rs.getString("BI_TITLE"));
						boardInfo.put("biContent", rs.getString("BI_CONTENT"));
						boardInfo.put("uiNum", rs.getString("UI_NUM"));
						boardInfo.put("credat", rs.getString("CREDAT"));
						boardInfo.put("cretim", rs.getString("CRETIM"));
						boardInfo.put("lmodat", rs.getString("LMODAT"));
						boardInfo.put("lmotim", rs.getString("LMOTIM"));
						boardInfo.put("active", rs.getString("ACTIVE"));
						return boardInfo;
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		String sql = "INSERT INTO BOARD_INFO(\r\n"
				+ "BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, \r\n"
				+ "CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?,?,?, DATE_FORMAT(NOW(), '%Y%m%d'), \r\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, board.get("biTitle"));
				pstmt.setString(2, board.get("biContent"));
				pstmt.setString(3, board.get("uiNum"));
				return pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		String sql = "UPDATE BOARD_INFO SET BI_TITLE=?, \r\n"
				+ "BI_CONTENT=?, UI_NUM=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'), LMOTIM=DATE_FORMAT(NOW(), '%H%i%s')\r\n"
				+ "WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, board.get("biTitle"));
				pstmt.setString(2, board.get("biContent"));
				pstmt.setString(3, board.get("uiNum"));
				pstmt.setString(4, board.get("biNum"));
				return pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, biNum);
				return pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

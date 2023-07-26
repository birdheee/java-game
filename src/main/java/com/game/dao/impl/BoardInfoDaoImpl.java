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
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		List<Map<String, String>> boardInfoList = new ArrayList<>();
		String sql = "SELECT BI_NUM, BI_TITLE, BI_WRITER, CREDAT, LMODAT, BI_CNT FROM BOARD_INFO WHERE 1=1";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				try(ResultSet rs = pstmt.executeQuery()){
					while(rs.next()) {
						Map<String, String> bi = new HashMap<>();
						bi.put("biNum", rs.getString("BI_NUM"));
						bi.put("biTitle", rs.getString("BI_TITLE"));
						bi.put("biWriter", rs.getString("BI_WRITER"));
						bi.put("credat", rs.getString("CREDAT"));
						bi.put("lmodat", rs.getString("LMODAT"));
						bi.put("biCnt", rs.getString("BI_CNT"));
						boardInfoList.add(bi);
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
		String sql = "SELECT BI_NUM, BI_TITLE, BI_WRITER, BI_CONTENT, CREDAT, LMODAT, BI_CNT \r\n"
				+ "FROM BOARD_INFO WHERE 1=1 AND BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, biNum);
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						boardInfo.put("biNum", rs.getString("BI_NUM"));
						boardInfo.put("biTitle", rs.getString("BI_TITLE"));
						boardInfo.put("biWriter", rs.getString("BI_WRITER"));
						boardInfo.put("biContent", rs.getString("BI_CONTENT"));
						boardInfo.put("credit", rs.getString("CREDAT"));
						boardInfo.put("lmodat", rs.getString("LMODAT"));
						boardInfo.put("biCnt", rs.getString("BI_CNT"));
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
	public int insertBoardInfo(Map<String, String> boardInfo) {
		String sql = "INSERT INTO BOARD_INFO(BI_TITLE, BI_WRITER, BI_CONTENT, CREDAT, LMODAT)\r\n"
				+ "VALUES(?,?,?, DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%Y%m%d'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, boardInfo.get("biTitle"));
				pstmt.setString(2, boardInfo.get("biWriter"));
				pstmt.setString(3, boardInfo.get("biContent"));
				return pstmt.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		String sql = "UPDATE BOARD_INFO SET BI_TITLE=?, \r\n"
				+ "BI_WRITER=?, BI_CONTENT=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(), '%Y%m%d') WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, boardInfo.get("biTitle"));
				pstmt.setString(2, boardInfo.get("biWriter"));
				pstmt.setString(3, boardInfo.get("biContent"));
				pstmt.setString(4, boardInfo.get("biNum"));
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

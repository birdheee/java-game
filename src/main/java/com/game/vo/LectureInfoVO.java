package com.game.vo;

public class LectureInfoVO {
	private int liNum;
	private String liName;
	private String liCode;
	private String liPro;
	private String liClass;
	private String liGrades;
	private String liRoom;
	private String searchType;
	private String searchStr;
	
	public int getLiNum() {
		return liNum;
	}
	public void setLiNum(int liNum) {
		this.liNum = liNum;
	}
	public String getLiName() {
		return liName;
	}
	public void setLiName(String liName) {
		this.liName = liName;
	}
	public String getLiCode() {
		return liCode;
	}
	public void setLiCode(String liCode) {
		this.liCode = liCode;
	}
	public String getLiPro() {
		return liPro;
	}
	public void setLiPro(String liPro) {
		this.liPro = liPro;
	}
	public String getLiClass() {
		return liClass;
	}
	public void setLiClass(String liClass) {
		this.liClass = liClass;
	}
	public String getLiGrades() {
		return liGrades;
	}
	public void setLiGrades(String liGrades) {
		this.liGrades = liGrades;
	}
	public String getLiRoom() {
		return liRoom;
	}
	public void setLiRoom(String liRoom) {
		this.liRoom = liRoom;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}
	
	@Override
	public String toString() {
		return "LectureInfoVO [liNum=" + liNum + ", liName=" + liName + ", liCode=" + liCode + ", liPro=" + liPro
				+ ", liClass=" + liClass + ", liGrades=" + liGrades + ", liRoom=" + liRoom + ", searchType="
				+ searchType + ", searchStr=" + searchStr + "]";
	}
}
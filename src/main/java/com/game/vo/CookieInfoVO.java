package com.game.vo;

public class CookieInfoVO {
	private int ciNum;
	private String ciName;
	private String ciImgPath;
	private String ciPos;
	private String ciType;
	private String ciGrade;
	private String ciBirth;
	private String ciSkill;
	private String ciDesc;
	private String searchType;
	private String searchStr;
	
	public int getCiNum() {
		return ciNum;
	}
	public void setCiNum(int ciNum) {
		this.ciNum = ciNum;
	}
	public String getCiName() {
		return ciName;
	}
	public void setCiName(String ciName) {
		this.ciName = ciName;
	}
	public String getCiImgPath() {
		return ciImgPath;
	}
	public void setCiImgPath(String ciImgPath) {
		this.ciImgPath = ciImgPath;
	}
	public String getCiPos() {
		return ciPos;
	}
	public void setCiPos(String ciPos) {
		this.ciPos = ciPos;
	}
	public String getCiType() {
		return ciType;
	}
	public void setCiType(String ciType) {
		this.ciType = ciType;
	}
	public String getCiGrade() {
		return ciGrade;
	}
	public void setCiGrade(String ciGrade) {
		this.ciGrade = ciGrade;
	}
	public String getCiBirth() {
		return ciBirth;
	}
	public void setCiBirth(String ciBirth) {
		this.ciBirth = ciBirth;
	}
	public String getCiSkill() {
		return ciSkill;
	}
	public void setCiSkill(String ciSkill) {
		this.ciSkill = ciSkill;
	}
	public String getCiDesc() {
		return ciDesc;
	}
	public void setCiDesc(String ciDesc) {
		this.ciDesc = ciDesc;
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
		return "CookieInfoVO [ciNum=" + ciNum + ", ciName=" + ciName + ", ciImgPath=" + ciImgPath + ", ciPos=" + ciPos
				+ ", ciType=" + ciType + ", ciGrade=" + ciGrade + ", ciBirth=" + ciBirth + ", ciSkill=" + ciSkill
				+ ", ciDesc=" + ciDesc + ", searchType=" + searchType + ", searchStr=" + searchStr + "]";
	}
	
}
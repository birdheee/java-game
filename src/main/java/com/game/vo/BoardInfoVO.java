package com.game.vo;

public class BoardInfoVO {
	private int biNum;
	private String biTitle;
	private String biContent;
	private int uiNum;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
	private String searchStr;
	private String searchType;
	private String uiName;
	
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public int getBiNum() {
		return biNum;
	}
	public void setBiNum(int biNum) {
		this.biNum = biNum;
	}
	public String getBiTitle() {
		return biTitle;
	}
	public void setBiTitle(String biTitle) {
		this.biTitle = biTitle;
	}
	public String getBiContent() {
		return biContent;
	}
	public void setBiContent(String biContent) {
		this.biContent = biContent;
	}
	public int getUiNum() {
		return uiNum;
	}
	public void setUiNum(int uiNum) {
		this.uiNum = uiNum;
	}
	public String getCredat() {
		return credat;
	}
	public void setCredat(String credat) {
		this.credat = credat;
	}
	public String getCretim() {
		return cretim;
	}
	public void setCretim(String cretim) {
		this.cretim = cretim;
	}
	public String getLmodat() {
		return lmodat;
	}
	public void setLmodat(String lmodat) {
		this.lmodat = lmodat;
	}
	public String getLmotim() {
		return lmotim;
	}
	public void setLmotim(String lmotim) {
		this.lmotim = lmotim;
	}
	
	@Override
	public String toString() {
		return "BoardInfoVO [biNum=" + biNum + ", biTitle=" + biTitle + ", biContent=" + biContent + ", uiNum=" + uiNum
				+ ", credat=" + credat + ", cretim=" + cretim + ", lmodat=" + lmodat + ", lmotim=" + lmotim
				+ ", searchStr=" + searchStr + ", searchType=" + searchType + ", uiName=" + uiName + "]";
	}
}
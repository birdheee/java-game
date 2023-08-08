package com.game.vo;

public class ValoInfoVO {
	private int viNum;
	private String viName;
	private String viPosition;
	private String viNation;
	private String viDesc;
	private String searchType;
	private String searchStr;
	
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

	public int getViNum() {
		return viNum;
	}
	
	public void setViNum(int viNum) {
		this.viNum = viNum;
	}

	public String getViName() {
		return viName;
	}

	public void setViName(String viName) {
		this.viName = viName;
	}

	public String getViPosition() {
		return viPosition;
	}

	public void setViPosition(String viPosition) {
		this.viPosition = viPosition;
	}
	
	public String getViNation() {
		return viNation;
	}

	public void setViNation(String viNation) {
		this.viNation = viNation;
	}

	public String getViDesc() {
		return viDesc;
	}

	public void setViDesc(String viDesc) {
		this.viDesc = viDesc;
	}

	@Override
	public String toString() {
		return "ValoInfoVO [viNum=" + viNum + ", viName=" + viName + ", viPosition=" + viPosition + ", viNation="
				+ viNation + ", viDesc=" + viDesc + "]";
	}
}

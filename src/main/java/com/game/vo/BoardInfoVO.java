package com.game.vo;

public class BoardInfoVO {
	// 하나의 map이 아니라 vo를 사용
	// 모든 변수 접근제어자는 private
	// int는 integer, 나머지는 String, datetime의 변수 String 권장
	
	private int biNum;
	private String biTitle;
	private String biContent;
	private int uiNum;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
	private String active;
	
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "BoardInfoVO [biNum=" + biNum + ", biTitle=" + biTitle + ", biContent=" + biContent + ", uiNum=" + uiNum
				+ ", credat=" + credat + ", cretim=" + cretim + ", lmodat=" + lmodat + ", lmotim=" + lmotim
				+ ", active=" + active + "]";
	}
	
}

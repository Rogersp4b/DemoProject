package com.example.demo;

import java.util.List;

public class CurrencyRs {

	private String code;
	
	private String codeCH;

	private String rate;
	
	private String updateTime;
	
	private List<CurrencyEntity> currencyList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCodeCH() {
		return codeCH;
	}

	public void setCodeCH(String codeCH) {
		this.codeCH = codeCH;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public List<CurrencyEntity> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<CurrencyEntity> currencyList) {
		this.currencyList = currencyList;
	}

}

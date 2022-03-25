package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CURRENCY")
@Getter
@Setter
public class CurrencyEntity {

	@Id
	@Column(name = "CODE")
	String code;
	
	@Column(name = "CODE_CH")
	String codeCH;

	@Column(name = "RATE")
	String rate;

	@Column(name = "UPDATE_TIME")
	String updateTime;

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

}

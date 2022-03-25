package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyObject {
	CurrencyObTime time;
	private String disclaimer;
	private String chartName;
	@JsonProperty("bpi")
	CurrencyObBpi bpi;

	// Getter Methods

	public CurrencyObTime getTime() {
		return time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public CurrencyObBpi getCurrencyObBpi() {
		return bpi;
	}

	// Setter Methods

	public void setTime(CurrencyObTime time) {
		this.time = time;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public void setCurrencyObBpi(CurrencyObBpi bpi) {
		this.bpi = bpi;
	}
}

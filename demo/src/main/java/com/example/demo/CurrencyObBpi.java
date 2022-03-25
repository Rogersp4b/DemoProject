package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyObBpi {
	@JsonProperty("USD")
	CurrencyObBpiUSD USD;
	@JsonProperty("GBP")
	CurrencyObBpiGBP GBP;
	@JsonProperty("EUR")
	CurrencyObBpiEUR EUR;

	// Getter Methods

	public CurrencyObBpiUSD getCurrencyObBpiUSD() {
		return USD;
	}

	public CurrencyObBpiGBP getCurrencyObBpiGBP() {
		return GBP;
	}

	public CurrencyObBpiEUR getCurrencyObBpiEUR() {
		return EUR;
	}

	// Setter Methods

	public void setCurrencyObBpiUSD(CurrencyObBpiUSD USD) {
		this.USD = USD;
	}

	public void setCurrencyObBpiGBP(CurrencyObBpiGBP GBP) {
		this.GBP = GBP;
	}

	public void setCurrencyObBpiEUR(CurrencyObBpiEUR EUR) {
		this.EUR = EUR;
	}
}

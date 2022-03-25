package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyObBpiEUR {
	 private String code;
	 private String symbol;
	 private String rate;
	 private String description;
	 @JsonProperty("rate_float")
	 private Float rateFloat;


	 // Getter Methods 

	 public String getCode() {
	  return code;
	 }

	 public String getSymbol() {
	  return symbol;
	 }

	 public String getRate() {
	  return rate;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public float getRateFloat() {
	  return rateFloat;
	 }

	 // Setter Methods 

	 public void setCode(String code) {
	  this.code = code;
	 }

	 public void setSymbol(String symbol) {
	  this.symbol = symbol;
	 }

	 public void setRate(String rate) {
	  this.rate = rate;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }

	 public void setRateFloat(float rateFloat) {
	  this.rateFloat = rateFloat;
	 }
}


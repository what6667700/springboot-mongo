package com.dc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

public class Stmacd implements Serializable {
	
	@Id
	private String id;
	@Indexed
	private String stockcode;
	private double macdh;
	private double macd;
	private double macds;
	private double close;
	private String datep;
	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	

	public double getMacdh() {
		return macdh;
	}

	public void setMacdh(double macdh) {
		this.macdh = macdh;
	}

	public double getMacd() {
		return macd;
	}

	public void setMacd(double macd) {
		this.macd = macd;
	}

	public double getMacds() {
		return macds;
	}

	public void setMacds(double macds) {
		this.macds = macds;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public String getDatep() {
		return datep;
	}

	public void setDatep(String datep) {
		this.datep = datep;
	}
	


	
	
}

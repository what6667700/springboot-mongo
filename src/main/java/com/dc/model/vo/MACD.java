package com.dc.model.vo;

import lombok.Data;

@Data
public class MACD {
	private double dif;
	private double dea;
	private double macd;// macd

	public MACD(double dif, double dea, double macd) {
		super();
		this.dif = dif;
		this.dea = dea;
		this.macd = macd;
	}

}

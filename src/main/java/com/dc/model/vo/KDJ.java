package com.dc.model.vo;

import lombok.Data;

@Data
public class KDJ {
	private double k;
	private double d;
	private double j;

	public KDJ(double k, double d, double j) {
		super();
		this.k = k;
		this.d = d;
		this.j = j;
	}

}
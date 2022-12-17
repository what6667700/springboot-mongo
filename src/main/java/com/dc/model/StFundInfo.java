package com.dc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

public class StFundInfo implements Serializable {
	
	@Id
	private String id;
	@Indexed
	private String stockcode;

	private String opendate;
	private double r0_net_5;
	private double r0_ratio_5;
	
	private double r0x_ratio_5;
	private double r0_net_3;
	private double r0_ratio_3;
	
	private double r0x_ratio_3;
	private double r0_net_10;
	private double r0_ratio_10;
	private double r0x_ratio_10;

	
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

	public String getOpendate() {
		return opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public double getR0_net_5() {
		return r0_net_5;
	}

	public void setR0_net_5(double r0_net_5) {
		this.r0_net_5 = r0_net_5;
	}

	public double getR0_ratio_5() {
		return r0_ratio_5;
	}

	public void setR0_ratio_5(double r0_ratio_5) {
		this.r0_ratio_5 = r0_ratio_5;
	}

	public double getR0x_ratio_5() {
		return r0x_ratio_5;
	}

	public void setR0x_ratio_5(double r0x_ratio_5) {
		this.r0x_ratio_5 = r0x_ratio_5;
	}

	public double getR0_net_3() {
		return r0_net_3;
	}

	public void setR0_net_3(double r0_net_3) {
		this.r0_net_3 = r0_net_3;
	}

	public double getR0_ratio_3() {
		return r0_ratio_3;
	}

	public void setR0_ratio_3(double r0_ratio_3) {
		this.r0_ratio_3 = r0_ratio_3;
	}

	public double getR0x_ratio_3() {
		return r0x_ratio_3;
	}

	public void setR0x_ratio_3(double r0x_ratio_3) {
		this.r0x_ratio_3 = r0x_ratio_3;
	}

	public double getR0_net_10() {
		return r0_net_10;
	}

	public void setR0_net_10(double r0_net_10) {
		this.r0_net_10 = r0_net_10;
	}

	public double getR0_ratio_10() {
		return r0_ratio_10;
	}

	public void setR0_ratio_10(double r0_ratio_10) {
		this.r0_ratio_10 = r0_ratio_10;
	}

	public double getR0x_ratio_10() {
		return r0x_ratio_10;
	}

	public void setR0x_ratio_10(double r0x_ratio_10) {
		this.r0x_ratio_10 = r0x_ratio_10;
	}
}

package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

public class MaketInfos implements Serializable {
	
	@Id
	private String id;

	private double volume;
	
	
	private String code;
	private double value_change;
	
	private double p_change;
	private double high;
	private double amount;

	
	private double pre_close;
	private double low;
	private String date;
	private double close;
	private double open; 
	
	private double ma5;
	private double ma10;
	private double ma20;
	private double ma30;
	private double ma60;
	private double ma120;
	private double ma240;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getValue_change() {
		return value_change;
	}
	public void setValue_change(double value_change) {
		this.value_change = value_change;
	}
	public double getP_change() {
		return p_change;
	}
	public void setP_change(double p_change) {
		this.p_change = p_change;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getPre_close() {
		return pre_close;
	}
	public void setPre_close(double pre_close) {
		this.pre_close = pre_close;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getMa5() {
		return ma5;
	}
	public void setMa5(double ma5) {
		this.ma5 = ma5;
	}
	public double getMa10() {
		return ma10;
	}
	public void setMa10(double ma10) {
		this.ma10 = ma10;
	}
	public double getMa20() {
		return ma20;
	}
	public void setMa20(double ma20) {
		this.ma20 = ma20;
	}
	public double getMa30() {
		return ma30;
	}
	public void setMa30(double ma30) {
		this.ma30 = ma30;
	}
	public double getMa60() {
		return ma60;
	}
	public void setMa60(double ma60) {
		this.ma60 = ma60;
	}
	public double getMa120() {
		return ma120;
	}
	public void setMa120(double ma120) {
		this.ma120 = ma120;
	}
	public double getMa240() {
		return ma240;
	}
	public void setMa240(double ma240) {
		this.ma240 = ma240;
	}
}

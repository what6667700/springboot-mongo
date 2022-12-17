package com.dc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


public class Boll implements Serializable {
	
	@Id
	private String id;
	
	private double upper;
	private double middle;
	private double lower;
	private String date;
	@Indexed
	private String code;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getUpper() {
		return upper;
	}

	public void setUpper(double upper) {
		this.upper = upper;
	}

	public double getMiddle() {
		return middle;
	}

	public void setMiddle(double middle) {
		this.middle = middle;
	}

	public double getLower() {
		return lower;
	}

	public void setLower(double lower) {
		this.lower = lower;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}

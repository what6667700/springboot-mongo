package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

public class Scpool implements Serializable {
	
	@Id
	private String id;
	@Indexed
	private String code;
	private String name;
	private String monitor;
	private String createTime;
	private String buyTime;
	private String sellTime;
	private String inOrOut;
	private double profit;
	private double inPrice;
	private double outPrice;
	
	
	
	public Scpool(){
		
	}
	
	public Scpool(String name, String code, String monitor, String createTime){
		id=UUID.randomUUID().toString();
//		SimpleDateFormat datetempInternal= new SimpleDateFormat("yyyy-MM-dd ");
//		Date date = new Date();
//		this.setNAME(NAME);
//		this.setCODE(CODE);
		
		this.setName(name);
		this.setCode(code);
		this.setMonitor(monitor);

		this.setSellTime(" ");
		this.setCreateTime(createTime);
	}
	
	
	public Scpool(String name, String code, String monitor, String createTime, String inOrOut, double inPrice , double outPrice, double profit){
		id=UUID.randomUUID().toString();
//		SimpleDateFormat datetempInternal= new SimpleDateFormat("yyyy-MM-dd ");
//		Date date = new Date();
//		this.setNAME(NAME);
//		this.setCODE(CODE);
		
		this.setName(name);
		this.setCode(code);
		this.setMonitor(monitor);
		
		this.setInOrOut(inOrOut);
		this.setProfit(profit);
		
		this.setInPrice(inPrice);
		this.setOutPrice(outPrice);

		this.setSellTime(" ");
		this.setCreateTime(createTime);
	}
	
	
	public Scpool(String name, String code, String monitor, String createTime, String buyTime, double inPrice ){
		id=UUID.randomUUID().toString();
//		SimpleDateFormat datetempInternal= new SimpleDateFormat("yyyy-MM-dd ");
//		Date date = new Date();
//		this.setNAME(NAME);
//		this.setCODE(CODE);
		
		this.setName(name);
		this.setCode(code);
		this.setMonitor(monitor);
		
		this.setInPrice(inPrice);
		this.setCreateTime(createTime);
		this.setBuyTime(buyTime);
		this.setSellTime(" ");
	}
	
	
	
	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public String getSellTime() {
		return sellTime;
	}

	public void setSellTime(String sellTime) {
		this.sellTime = sellTime;
	}

	public String getCreateTime() {
		return createTime;
	}


	public double getInPrice() {
		return inPrice;
	}


	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}


	public double getOutPrice() {
		return outPrice;
	}


	public void setOutPrice(double outPrice) {
		this.outPrice = outPrice;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getInOrOut() {
		return inOrOut;
	}


	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}


	public double getProfit() {
		return profit;
	}


	public void setProfit(double profit) {
		this.profit = profit;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String endDateStr() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	
}

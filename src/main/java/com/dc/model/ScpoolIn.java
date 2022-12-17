package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import java.io.Serializable;
import java.util.UUID;


public class ScpoolIn implements Serializable {
	
	@Id
	private String id;
	@Indexed
	private String code;
	private String name;
	private String buyTime;
	private int buyAmount;
	private double buyPrice;
	
	private String sellTime;
	private int sellAmount;
	private double sellPrice;
	
	private double scPosition;
	
	private double scReturn;
	
	
	public ScpoolIn(String name, String code,
					String buyTime, int buyAmount,
					double buyPrice, String sellTime, int sellAmount,
					double sellPrice, double scPosition, double scReturn){
		id=UUID.randomUUID().toString();
//		SimpleDateFormat datetempInternal= new SimpleDateFormat("yyyy-MM-dd ");
//		Date date = new Date();
		this.setName(name);
		this.setCode(code);
		this.setBuyTime(buyTime);
		this.setBuyAmount(buyAmount);
		this.setBuyPrice(buyPrice);
		
		this.setSellAmount(sellAmount);
		this.setSellTime(sellTime);
		this.setSellPrice(sellPrice);
		
		this.setScPosition(scPosition);
		
		this.setScReturn(scReturn);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	


	



	public double getScReturn() {
		return scReturn;
	}

	public void setScReturn(double scReturn) {
		this.scReturn = scReturn;
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

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public int getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}

	
	public String getSellTime() {
		return sellTime;
	}

	public void setSellTime(String sellTime) {
		this.sellTime = sellTime;
	}

	public int getSellAmount() {
		return sellAmount;
	}

	public void setSellAmount(int sellAmount) {
		this.sellAmount = sellAmount;
	}

	
	public double getScPosition() {
		return scPosition;
	}

	public void setScPosition(double scPosition) {
		this.scPosition = scPosition;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	
	
	
	
	
	
}

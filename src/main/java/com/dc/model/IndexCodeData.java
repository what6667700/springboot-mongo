package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

public class IndexCodeData implements Serializable {
	
	@Id
	private String id;
	private String  TCAP;
	private String CODE;
	@Indexed
	private String NAME;
	private double HIGHESTPRICE;
	private double PERCENT;
	private double UPDOWN;
	private double PREVIOUSCLOSE;
	private double VOLUME;
	private String  MCAP;
	private String HS;
	private double CLOSE;
	private double LOWESTPRICE;
	private double OPEN;
	private Date TIME; 
	private double TURNOVER;

	private Double ma5;
	private Double ma10;
	private Double ma20;
	private Double ma30;
	private Double ma60;
	private Double ma120;
	private Double ma250;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getTCAP() {
		return TCAP;
	}

	public void setTCAP(String TCAP) {
		this.TCAP = TCAP;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public double getHIGHESTPRICE() {
		return HIGHESTPRICE;
	}

	public void setHIGHESTPRICE(double HIGHESTPRICE) {
		this.HIGHESTPRICE = HIGHESTPRICE;
	}

	public double getPERCENT() {
		return PERCENT;
	}

	public void setPERCENT(double PERCENT) {
		this.PERCENT = PERCENT;
	}

	public double getUPDOWN() {
		return UPDOWN;
	}

	public void setUPDOWN(double UPDOWN) {
		this.UPDOWN = UPDOWN;
	}

	public double getPREVIOUSCLOSE() {
		return PREVIOUSCLOSE;
	}

	public void setPREVIOUSCLOSE(double PREVIOUSCLOSE) {
		this.PREVIOUSCLOSE = PREVIOUSCLOSE;
	}

	public double getVOLUME() {
		return VOLUME;
	}

	public void setVOLUME(double VOLUME) {
		this.VOLUME = VOLUME;
	}

	public String getMCAP() {
		return MCAP;
	}

	public void setMCAP(String MCAP) {
		this.MCAP = MCAP;
	}

	public String getHS() {
		return HS;
	}

	public void setHS(String HS) {
		this.HS = HS;
	}

	public double getCLOSE() {
		return CLOSE;
	}

	public void setCLOSE(double CLOSE) {
		this.CLOSE = CLOSE;
	}

	public double getLOWESTPRICE() {
		return LOWESTPRICE;
	}

	public void setLOWESTPRICE(double LOWESTPRICE) {
		this.LOWESTPRICE = LOWESTPRICE;
	}

	public double getOPEN() {
		return OPEN;
	}

	public void setOPEN(double OPEN) {
		this.OPEN = OPEN;
	}

	public Date getTIME() {
		return TIME;
	}

	public void setTIME(Date TIME) {
		this.TIME = TIME;
	}

	public double getTURNOVER() {
		return TURNOVER;
	}

	public void setTURNOVER(double TURNOVER) {
		this.TURNOVER = TURNOVER;
	}

	public Double getMa5() {
		return ma5;
	}

	public void setMa5(Double ma5) {
		this.ma5 = ma5;
	}

	public Double getMa10() {
		return ma10;
	}

	public void setMa10(Double ma10) {
		this.ma10 = ma10;
	}

	public Double getMa20() {
		return ma20;
	}

	public void setMa20(Double ma20) {
		this.ma20 = ma20;
	}

	public Double getMa30() {
		return ma30;
	}

	public void setMa30(Double ma30) {
		this.ma30 = ma30;
	}

	public Double getMa60() {
		return ma60;
	}

	public void setMa60(Double ma60) {
		this.ma60 = ma60;
	}

	public Double getMa120() {
		return ma120;
	}

	public void setMa120(Double ma120) {
		this.ma120 = ma120;
	}

	public Double getMa250() {
		return ma250;
	}

	public void setMa250(Double ma250) {
		this.ma250 = ma250;
	}
}

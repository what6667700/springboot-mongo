package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection="stockCode")
public class StockCode implements Serializable {
	
	@Id
	private String id;
	private double  TCAP;
	private String CODE;
	@Indexed
	private String NAME;
	private String HIGHESTPRICE;
	private String PERCENT;
	private String UPDOWN;
	private String SYMBOL;
	private String PE;
	private String PREVIOUSCLOSE;
	private String MFRATIO2;
	private String VOLUME;
	private String MFSUM;
	private String  MCAP;
	private String HS;
	private String CLOSE;
	private String LOWESTPRICE;
	private String MFRATIO10;
	private String OPEN;
	private Date TIME; 
	private String TURNOVER;
	
	private String PROFIT;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTCAP() {
		return TCAP;
	}

	public void setTCAP(double tCAP) {
		TCAP = tCAP;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getHIGHESTPRICE() {
		return HIGHESTPRICE;
	}

	public void setHIGHESTPRICE(String hIGHESTPRICE) {
		HIGHESTPRICE = hIGHESTPRICE;
	}

	public String getPERCENT() {
		return PERCENT;
	}

	public void setPERCENT(String pERCENT) {
		PERCENT = pERCENT;
	}

	public String getUPDOWN() {
		return UPDOWN;
	}

	public void setUPDOWN(String uPDOWN) {
		UPDOWN = uPDOWN;
	}

	public String getSYMBOL() {
		return SYMBOL;
	}

	public void setSYMBOL(String sYMBOL) {
		SYMBOL = sYMBOL;
	}

	public String getPE() {
		return PE;
	}

	public void setPE(String pE) {
		PE = pE;
	}

	public String getPREVIOUSCLOSE() {
		return PREVIOUSCLOSE;
	}

	public void setPREVIOUSCLOSE(String pREVIOUSCLOSE) {
		PREVIOUSCLOSE = pREVIOUSCLOSE;
	}

	public String getMFRATIO2() {
		return MFRATIO2;
	}

	public void setMFRATIO2(String mFRATIO2) {
		MFRATIO2 = mFRATIO2;
	}

	public String getVOLUME() {
		return VOLUME;
	}

	public void setVOLUME(String vOLUME) {
		VOLUME = vOLUME;
	}

	public String getMFSUM() {
		return MFSUM;
	}

	public void setMFSUM(String mFSUM) {
		MFSUM = mFSUM;
	}

	public String getMCAP() {
		return MCAP;
	}

	public void setMCAP(String mCAP) {
		MCAP = mCAP;
	}

	public String getHS() {
		return HS;
	}

	public void setHS(String hS) {
		HS = hS;
	}

	public String getCLOSE() {
		return CLOSE;
	}

	public void setCLOSE(String cLOSE) {
		CLOSE = cLOSE;
	}

	public String getLOWESTPRICE() {
		return LOWESTPRICE;
	}

	public void setLOWESTPRICE(String lOWESTPRICE) {
		LOWESTPRICE = lOWESTPRICE;
	}

	public String getMFRATIO10() {
		return MFRATIO10;
	}

	public void setMFRATIO10(String mFRATIO10) {
		MFRATIO10 = mFRATIO10;
	}

	public String getOPEN() {
		return OPEN;
	}

	public void setOPEN(String oPEN) {
		OPEN = oPEN;
	}

	public Date getTIME() {
		return TIME;
	}

	public void setTIME(Date tIME) {
		TIME = tIME;
	}

	public String getTURNOVER() {
		return TURNOVER;
	}

	public void setTURNOVER(String tURNOVER) {
		TURNOVER = tURNOVER;
	}

	public String getPROFIT() {
		return PROFIT;
	}

	public void setPROFIT(String pROFIT) {
		PROFIT = pROFIT;
	}
	

	
	
	
}

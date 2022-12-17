package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection="stock")
public class Stock implements Serializable {
	
	@Id
	private String id;

	private String HIGHESTPRICE;
	
	
	private String CODE;
	@Indexed
	private String NAME;
	private String PERCENT;
	private String UPDOWN;
	private String PREVIOUSCLOSE;
	private String VOLUME;
	private String MCAP; 
	
	private String LOWESTPRICE;
	private String OPEN;
	private String TCAP;
	private String HS;
	@Indexed
	private Date TIME; 
	
	private String CLOSE;
	private String TURNOVER;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHIGHESTPRICE() {
		return HIGHESTPRICE;
	}
	public void setHIGHESTPRICE(String hIGHESTPRICE) {
		HIGHESTPRICE = hIGHESTPRICE;
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
	public String getPREVIOUSCLOSE() {
		return PREVIOUSCLOSE;
	}
	public void setPREVIOUSCLOSE(String pREVIOUSCLOSE) {
		PREVIOUSCLOSE = pREVIOUSCLOSE;
	}
	public String getVOLUME() {
		return VOLUME;
	}
	public void setVOLUME(String vOLUME) {
		VOLUME = vOLUME;
	}
	public String getMCAP() {
		return MCAP;
	}
	public void setMCAP(String mCAP) {
		MCAP = mCAP;
	}
	public String getLOWESTPRICE() {
		return LOWESTPRICE;
	}
	public void setLOWESTPRICE(String lOWESTPRICE) {
		LOWESTPRICE = lOWESTPRICE;
	}
	public String getOPEN() {
		return OPEN;
	}
	public void setOPEN(String oPEN) {
		OPEN = oPEN;
	}
	public String getTCAP() {
		return TCAP;
	}
	public void setTCAP(String tCAP) {
		TCAP = tCAP;
	}
	public String getHS() {
		return HS;
	}
	public void setHS(String hS) {
		HS = hS;
	}
	public Date getTIME() {
		return TIME;
	}
	public void setTIME(Date tIME) {
		TIME = tIME;
	}
	public String getCLOSE() {
		return CLOSE;
	}
	public void setCLOSE(String cLOSE) {
		CLOSE = cLOSE;
	}
	public String getTURNOVER() {
		return TURNOVER;
	}
	public void setTURNOVER(String tURNOVER) {
		TURNOVER = tURNOVER;
	}
	
	
	
	
	
	
	
}

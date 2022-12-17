package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

public class Stockjjcgph implements Serializable {
	
	@Id
	private String id;
	private String CODE;
	@Indexed
	private String REPORTDATE;
	private String ESYMBOL;
	private String EXCHANGE;
	private String GUSHU;
	private String GUSHUBIJIAO;
	private String RN;
	private String SCSTC27;
	private String SHANGQIGUSHU;
	private String SHANGQISHIZHI;
	private String SHANGQISHULIANG;
	private String SHIZHI;
	@Indexed
	private String SHULIANG;
	private String SHULIANGBIJIAO;
	private String SNAME;
	private String SYMBOL;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
	}

	public String getREPORTDATE() {
		return REPORTDATE;
	}

	public void setREPORTDATE(String REPORTDATE) {
		this.REPORTDATE = REPORTDATE;
	}

	public String getESYMBOL() {
		return ESYMBOL;
	}

	public void setESYMBOL(String ESYMBOL) {
		this.ESYMBOL = ESYMBOL;
	}

	public String getEXCHANGE() {
		return EXCHANGE;
	}

	public void setEXCHANGE(String EXCHANGE) {
		this.EXCHANGE = EXCHANGE;
	}

	public String getGUSHU() {
		return GUSHU;
	}

	public void setGUSHU(String GUSHU) {
		this.GUSHU = GUSHU;
	}

	public String getGUSHUBIJIAO() {
		return GUSHUBIJIAO;
	}

	public void setGUSHUBIJIAO(String GUSHUBIJIAO) {
		this.GUSHUBIJIAO = GUSHUBIJIAO;
	}

	public String getRN() {
		return RN;
	}

	public void setRN(String RN) {
		this.RN = RN;
	}

	public String getSCSTC27() {
		return SCSTC27;
	}

	public void setSCSTC27(String SCSTC27) {
		this.SCSTC27 = SCSTC27;
	}

	public String getSHANGQIGUSHU() {
		return SHANGQIGUSHU;
	}

	public void setSHANGQIGUSHU(String SHANGQIGUSHU) {
		this.SHANGQIGUSHU = SHANGQIGUSHU;
	}

	public String getSHANGQISHIZHI() {
		return SHANGQISHIZHI;
	}

	public void setSHANGQISHIZHI(String SHANGQISHIZHI) {
		this.SHANGQISHIZHI = SHANGQISHIZHI;
	}

	public String getSHANGQISHULIANG() {
		return SHANGQISHULIANG;
	}

	public void setSHANGQISHULIANG(String SHANGQISHULIANG) {
		this.SHANGQISHULIANG = SHANGQISHULIANG;
	}

	public String getSHIZHI() {
		return SHIZHI;
	}

	public void setSHIZHI(String SHIZHI) {
		this.SHIZHI = SHIZHI;
	}

	public String getSHULIANG() {
		return SHULIANG;
	}

	public void setSHULIANG(String SHULIANG) {
		this.SHULIANG = SHULIANG;
	}

	public String getSHULIANGBIJIAO() {
		return SHULIANGBIJIAO;
	}

	public void setSHULIANGBIJIAO(String SHULIANGBIJIAO) {
		this.SHULIANGBIJIAO = SHULIANGBIJIAO;
	}

	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String SNAME) {
		this.SNAME = SNAME;
	}

	public String getSYMBOL() {
		return SYMBOL;
	}

	public void setSYMBOL(String SYMBOL) {
		this.SYMBOL = SYMBOL;
	}
}

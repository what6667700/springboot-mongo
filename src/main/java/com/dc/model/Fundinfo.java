package com.dc.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


public class Fundinfo implements Serializable {
	
	@Id
	private String id;
	@Indexed
	private String code;

	private String date;
	private String zjlc;
	private String zllr;
	
	private String hsl;
	private String zljlr;
	private String spj;
	
	private String zjlr;
	private String zllc;
	private String jlr;
	private String zdf;
	
	public Fundinfo(){
		
	}

//	public fundinfo(STFundInfo stFundInfo,String stockcode){
//		id=UUID.randomUUID().toString();
//		this.setStockcode(stockcode);
//		this.setOpendate(stFundInfo.getOpendate());
//		this.setR0_net_5(stFundInfo.getR0_net_5());
//		
//		this.setR0_ratio_5(stFundInfo.getR0_ratio_5());
//		this.setR0x_ratio_5(stFundInfo.getR0x_ratio_5());
//		
//		this.setR0_net_3(stFundInfo.getR0_net_3());
//		this.setR0_ratio_3(stFundInfo.getR0_ratio_3());
//		this.setR0x_ratio_3(stFundInfo.getR0x_ratio_3());
//		
//		this.setR0_net_10(stFundInfo.getR0_net_10());
//		this.setR0_ratio_10(stFundInfo.getR0_ratio_10());
//		this.setR0x_ratio_10(stFundInfo.getR0x_ratio_10());
//	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getZjlc() {
		return zjlc;
	}

	public void setZjlc(String zjlc) {
		this.zjlc = zjlc;
	}

	public String getZllr() {
		return zllr;
	}

	public void setZllr(String zllr) {
		this.zllr = zllr;
	}

	public String getHsl() {
		return hsl;
	}

	public void setHsl(String hsl) {
		this.hsl = hsl;
	}

	public String getZljlr() {
		return zljlr;
	}

	public void setZljlr(String zljlr) {
		this.zljlr = zljlr;
	}

	public String getSpj() {
		return spj;
	}

	public void setSpj(String spj) {
		this.spj = spj;
	}

	public String getZjlr() {
		return zjlr;
	}

	public void setZjlr(String zjlr) {
		this.zjlr = zjlr;
	}

	public String getZllc() {
		return zllc;
	}

	public void setZllc(String zllc) {
		this.zllc = zllc;
	}

	public String getJlr() {
		return jlr;
	}

	public void setJlr(String jlr) {
		this.jlr = jlr;
	}

	public String getZdf() {
		return zdf;
	}

	public void setZdf(String zdf) {
		this.zdf = zdf;
	}

}

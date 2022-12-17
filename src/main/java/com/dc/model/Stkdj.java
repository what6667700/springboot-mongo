package com.dc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


public class Stkdj implements Serializable {

	@Id
	private String id;
	@Indexed
	private String ts_code;

	@Indexed
	private String trade_date;

	
	private double kdjk;
	
	private double kdjj;
	
	private double kdjd;

	
	private double macdh;
	
	private double macd;
	
	private double macds;

	
	private double boll;
	
	private double boll_ub;
	
	private double boll_lb;

	
	private double cci;
	
	private double cci_20;
	
	private double rsi_6;
	
	private double rsi_12;
	
	private double dma;

	//'volume','price_change','turnover','ma5','ma10','ma20','v_ma5','v_ma10','v_ma20','p_change',
	private double open;
	private double high;
	private double low;
	private double close;
	private double vol;
	private double price_change;
//	private double turnover;
	private double ma5;
	private double ma10;
	private double ma20;
	private double ma50;
	private double ddd;
	private double ama;

	
	private double v_ma5;
	
	private double v_ma10;
	
	private double v_ma20;
	
	private double pct_chg;

	public double getVol() {
		return vol;
	}

	public void setVol(double vol) {
		this.vol = vol;
	}

	public double getPct_chg() {
		return pct_chg;
	}

	public void setPct_chg(double pct_chg) {
		this.pct_chg = pct_chg;
	}

	public String getTs_code() {
		return ts_code;
	}

	public void setTs_code(String ts_code) {
		this.ts_code = ts_code;
	}

	public String getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}


	public double getMa50() {
		return ma50;
	}

	public void setMa50(double ma50) {
		this.ma50 = ma50;
	}

	public double getDdd() {
		return ddd;
	}

	public void setDdd(double ddd) {
		this.ddd = ddd;
	}

	public double getAma() {
		return ama;
	}

	public void setAma(double ama) {
		this.ama = ama;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public double getKdjk() {
		return kdjk;
	}

	public void setKdjk(double kdjk) {
		this.kdjk = kdjk;
	}

	public double getKdjj() {
		return kdjj;
	}

	public void setKdjj(double kdjj) {
		this.kdjj = kdjj;
	}

	public double getKdjd() {
		return kdjd;
	}

	public void setKdjd(double kdjd) {
		this.kdjd = kdjd;
	}

	public double getMacdh() {
		return macdh;
	}

	public void setMacdh(double macdh) {
		this.macdh = macdh;
	}

	public double getMacd() {
		return macd;
	}

	public void setMacd(double macd) {
		this.macd = macd;
	}

	public double getMacds() {
		return macds;
	}

	public void setMacds(double macds) {
		this.macds = macds;
	}

	public double getBoll() {
		return boll;
	}

	public void setBoll(double boll) {
		this.boll = boll;
	}

	public double getBoll_ub() {
		return boll_ub;
	}

	public void setBoll_ub(double boll_ub) {
		this.boll_ub = boll_ub;
	}

	public double getBoll_lb() {
		return boll_lb;
	}

	public void setBoll_lb(double boll_lb) {
		this.boll_lb = boll_lb;
	}

	public double getCci() {
		return cci;
	}

	public void setCci(double cci) {
		this.cci = cci;
	}

	public double getCci_20() {
		return cci_20;
	}

	public void setCci_20(double cci_20) {
		this.cci_20 = cci_20;
	}

	public double getRsi_6() {
		return rsi_6;
	}

	public void setRsi_6(double rsi_6) {
		this.rsi_6 = rsi_6;
	}

	public double getRsi_12() {
		return rsi_12;
	}

	public void setRsi_12(double rsi_12) {
		this.rsi_12 = rsi_12;
	}

	public double getDma() {
		return dma;
	}

	public void setDma(double dma) {
		this.dma = dma;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}


	public double getPrice_change() {
		return price_change;
	}

	public void setPrice_change(double price_change) {
		this.price_change = price_change;
	}

//	public double getTurnover() {
//		return turnover;
//	}
//
//	public void setTurnover(double turnover) {
//		this.turnover = turnover;
//	}

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

	public double getV_ma5() {
		return v_ma5;
	}

	public void setV_ma5(double v_ma5) {
		this.v_ma5 = v_ma5;
	}

	public double getV_ma10() {
		return v_ma10;
	}

	public void setV_ma10(double v_ma10) {
		this.v_ma10 = v_ma10;
	}



	public double getV_ma20() {
		return v_ma20;
	}

	public void setV_ma20(double v_ma20) {
		this.v_ma20 = v_ma20;
	}




}

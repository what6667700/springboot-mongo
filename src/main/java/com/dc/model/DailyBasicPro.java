package com.dc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection="dailyBasicPro")
public class DailyBasicPro implements Serializable {

    @Id
    private String id;
	private int index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Indexed
	private String ts_code;
    @Indexed
	private String trade_date;
    private double close;
    private double turnover_rate;
	private double turnover_rate_f;
	private double volume_ratio;
	private double pb;
	
	private double ps;
	private double ps_ttm;
	private double total_share;
	
	private double float_share;
	private double free_share;
	private double total_mv;
	private double circ_mv;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getTurnover_rate() {
        return turnover_rate;
    }

    public void setTurnover_rate(double turnover_rate) {
        this.turnover_rate = turnover_rate;
    }

    public double getTurnover_rate_f() {
        return turnover_rate_f;
    }

    public void setTurnover_rate_f(double turnover_rate_f) {
        this.turnover_rate_f = turnover_rate_f;
    }

    public double getVolume_ratio() {
        return volume_ratio;
    }

    public void setVolume_ratio(double volume_ratio) {
        this.volume_ratio = volume_ratio;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getPs() {
        return ps;
    }

    public void setPs(double ps) {
        this.ps = ps;
    }

    public double getPs_ttm() {
        return ps_ttm;
    }

    public void setPs_ttm(double ps_ttm) {
        this.ps_ttm = ps_ttm;
    }

    public double getTotal_share() {
        return total_share;
    }

    public void setTotal_share(double total_share) {
        this.total_share = total_share;
    }

    public double getFloat_share() {
        return float_share;
    }

    public void setFloat_share(double float_share) {
        this.float_share = float_share;
    }

    public double getFree_share() {
        return free_share;
    }

    public void setFree_share(double free_share) {
        this.free_share = free_share;
    }

    public double getTotal_mv() {
        return total_mv;
    }

    public void setTotal_mv(double total_mv) {
        this.total_mv = total_mv;
    }

    public double getCirc_mv() {
        return circ_mv;
    }

    public void setCirc_mv(double circ_mv) {
        this.circ_mv = circ_mv;
    }
}

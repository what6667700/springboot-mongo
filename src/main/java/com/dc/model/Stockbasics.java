package com.dc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection="stockbasics")
public class Stockbasics implements Serializable {
	
	@Id
	private String id;
	@Indexed
	private String code;

    private String name;
    private String industry;
    private String area;


	private double pe;
	private double outstanding;
	private double totals;
	
	private double totalAssets;
	private double liquidAssets;
	private double fixedAssets;
	
	private double reserved;
	private double reservedPerShare;
	private double esp;


	private double bvps;
	private double pb;
	private double timeToMarket;
	private double undp;
	
	private double perundp;
	
	//'volume','price_change','turnover','ma5','ma10','ma20','v_ma5','v_ma10','v_ma20','p_change',
    @Indexed
    private double rev;
    @Indexed
	private double profit;
	private double gpr;
	private double npr;
	private double holders;


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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(double outstanding) {
        this.outstanding = outstanding;
    }

    public double getTotals() {
        return totals;
    }

    public void setTotals(double totals) {
        this.totals = totals;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public double getLiquidAssets() {
        return liquidAssets;
    }

    public void setLiquidAssets(double liquidAssets) {
        this.liquidAssets = liquidAssets;
    }

    public double getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(double fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public double getReserved() {
        return reserved;
    }

    public void setReserved(double reserved) {
        this.reserved = reserved;
    }

    public double getReservedPerShare() {
        return reservedPerShare;
    }

    public void setReservedPerShare(double reservedPerShare) {
        this.reservedPerShare = reservedPerShare;
    }

    public double getEsp() {
        return esp;
    }

    public void setEsp(double esp) {
        this.esp = esp;
    }

    public double getBvps() {
        return bvps;
    }

    public void setBvps(double bvps) {
        this.bvps = bvps;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getTimeToMarket() {
        return timeToMarket;
    }

    public void setTimeToMarket(double timeToMarket) {
        this.timeToMarket = timeToMarket;
    }

    public double getUndp() {
        return undp;
    }

    public void setUndp(double undp) {
        this.undp = undp;
    }

    public double getPerundp() {
        return perundp;
    }

    public void setPerundp(double perundp) {
        this.perundp = perundp;
    }

    public double getRev() {
        return rev;
    }

    public void setRev(double rev) {
        this.rev = rev;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getGpr() {
        return gpr;
    }

    public void setGpr(double gpr) {
        this.gpr = gpr;
    }

    public double getNpr() {
        return npr;
    }

    public void setNpr(double npr) {
        this.npr = npr;
    }

    public double getHolders() {
        return holders;
    }

    public void setHolders(double holders) {
        this.holders = holders;
    }
}

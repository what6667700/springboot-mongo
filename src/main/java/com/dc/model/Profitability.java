package com.dc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


public class Profitability implements Serializable {
	
	@Id
	private String id;
	@Indexed
	private String code;
    @Indexed
    private String name;


	private double roe;
	private double net_profit_ratio;
	private double gross_profit_rate;
	
	private double net_profits;
	private double eps;
	private double business_income;
	
	private double bips;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
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


    public double getRoe() {
        return roe;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }

    public double getNet_profit_ratio() {
        return net_profit_ratio;
    }

    public void setNet_profit_ratio(double net_profit_ratio) {
        this.net_profit_ratio = net_profit_ratio;
    }

    public double getGross_profit_rate() {
        return gross_profit_rate;
    }

    public void setGross_profit_rate(double gross_profit_rate) {
        this.gross_profit_rate = gross_profit_rate;
    }

    public double getNet_profits() {
        return net_profits;
    }

    public void setNet_profits(double net_profits) {
        this.net_profits = net_profits;
    }


    public double getBusiness_income() {
        return business_income;
    }

    public void setBusiness_income(double business_income) {
        this.business_income = business_income;
    }

    public double getBips() {
        return bips;
    }

    public void setBips(double bips) {
        this.bips = bips;
    }
}

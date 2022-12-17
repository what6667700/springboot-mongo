package com.dc.model.vo;

import com.dc.model.HistorytradeInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StrategyVo {
	private String code;// 股票代码
	private int cycle;//周期
	private boolean init;

	private List<MACD> macd = new ArrayList<>();// macd
	private List<KDJ> kdj = new ArrayList<>();// kdj
	private List<HistorytradeInfo> stockHistories = new ArrayList<>();// k线


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}


	public List<HistorytradeInfo> getStockHistories() {
		return stockHistories;
	}


	public List<MACD> getMacd() {
		return macd;
	}

	public void setMacd(List<MACD> macd) {
		this.macd = macd;
	}

	public List<KDJ> getKdj() {
		return kdj;
	}

	public void setKdj(List<KDJ> kdj) {
		this.kdj = kdj;
	}
}

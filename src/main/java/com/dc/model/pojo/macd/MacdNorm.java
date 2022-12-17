package com.dc.model.pojo.macd;

import com.dc.model.HistorytradeInfo;
import com.dc.model.pojo.Norm;
import com.dc.model.vo.MACD;
import com.dc.model.vo.StrategyVo;

import java.util.ArrayList;
import java.util.List;

/**
 * macd指标计算
 * 
 * @author Administrator
 *
 */
public class MacdNorm implements Norm {
	private static final int SHORT_TIME = 12;
	private static final int LONG_TIME = 26;
	private static final int MID = 9;
	private static final MacdNorm MACD = new MacdNorm();

	public static MacdNorm getInstance() {
		return MACD;
	}

	/**
	 * 预处理
	 *
	 * @param vo
	 */
	@Override
	public void handle(StrategyVo vo) {
		calcMACD(vo);
	}

	/*
	 * 计算EMA指数平滑移动平均线，用于MACD
	 */
	private List<Double> calcEMA(double n, List<HistorytradeInfo> data) {
		List<Double> ema = new ArrayList<>();
		double a = 2.0 / (n + 1);
		ema.add(data.get(0).getClose());
		for (int i = 1, l = data.size(); i < l; i++) {
			double v = a * data.get(i).getClose();
			double v1 = (1 - a) * ema.get(i - 1);
			ema.add(getDouble(v + v1));
		}
		return ema;
	}

	/*
	 * 计算DIF快线，用于MACD
	 */
	private List<Double> calcDIF(List<HistorytradeInfo> data) {
		List<Double> dif = new ArrayList<>();
		List<Double> emaShort = calcEMA(SHORT_TIME, data);
		List<Double> emaLong = calcEMA(LONG_TIME, data);
		for (int i = 0, l = data.size(); i < l; i++) {
			double d = emaShort.get(i) - emaLong.get(i);
			dif.add(getDouble(d));
		}
		return dif;
	}

	/*
	 * 计算DEA慢线，用于MACD
	 */
	private List<Double> calcDEA(List<Double> dif) {
		List<Double> ema = new ArrayList<>();
		double a = 2.0 / (MID + 1);
		ema.add(dif.get(0));
		for (int i = 1, l = dif.size(); i < l; i++) {
			double d = a * dif.get(i) + (1 - a) * ema.get(i - 1);
			ema.add(getDouble(d));
		}
		return ema;
	}

	/*
	 * 计算MACD
	 */
	private void calcMACD(StrategyVo vo) {
		List<HistorytradeInfo> klines = vo.getStockHistories();
		List<Double> macd = new ArrayList<>();
		List<Double> dif = calcDIF(klines);
		List<Double> dea = calcDEA(dif);
		for (int i = 0, l = klines.size(); i < l; i++) {
			double d = (dif.get(i) - dea.get(i)) * 2;
			macd.add(getDouble(d));
		}
		List<MACD> list = vo.getMacd();
		list.clear();
		for (int i = 0; i < macd.size(); i++) {
			list.add(new MACD(dif.get(i), dea.get(i), macd.get(i)));
		}
	}

}

package com.dc.model.pojo.kdj;


import com.dc.model.HistorytradeInfo;
import com.dc.model.vo.KDJ;
import com.dc.model.vo.StrategyVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * kdj指标
 * 
 * @author Administrator
 *
 */
public class KdjDaily {
	private static final KdjDaily KDJ = new KdjDaily();

	public static KdjDaily getInstance() {
		return KDJ;
	}

	public void handle(StrategyVo vo) {
		List<HistorytradeInfo> klines = vo.getStockHistories();
		double[] close = new double[klines.size()];
		double[] high = new double[klines.size()];
		double[] low = new double[klines.size()];
		for (int i = 0; i < klines.size(); i++) {
			HistorytradeInfo kline = klines.get(i);
			close[i] = kline.getClose();
			high[i] = kline.getHigh();
			low[i] = kline.getLow();
		}

		int length = high.length;
		double outSlowK[] = new double[high.length];
		double outSlowD[] = new double[high.length];
		double outSlowJ[] = new double[high.length];
		double[] RSV = new double[high.length];

		for (int i = 0; i < length; i++) {
			if (i >= 8) {
				int start = i - 8;
				double high9 = Double.MIN_VALUE;
				double low9 = Double.MAX_VALUE;
				while (start <= i) {
					if (high[start] > high9) {
						high9 = high[start];
					}
					if (low[start] < low9) {
						low9 = low[start];
					}
					start++;
				}
				RSV[i] = (close[i] - low9) / (high9 - low9) * 100;
			} else {
				RSV[i] = 0d;
			}
		}

		for (int i = 0; i < length; i++) {
			if (i > 1) {
				outSlowK[i] = getBigDecimail(2 / 3d * outSlowK[i - 1] + 1 / 3d * RSV[i]);
				outSlowD[i] = getBigDecimail(2 / 3d * outSlowD[i - 1] + 1 / 3d * outSlowK[i]);
				outSlowJ[i] = getBigDecimail(3 * outSlowK[i] - 2 * outSlowD[i]);

				if (outSlowJ[i] > 100) {
					outSlowJ[i] = 100;
				} else if (outSlowJ[i] < 0) {
					outSlowJ[i] = 0;
				}
			} else {
				outSlowK[i] = 50;
				outSlowD[i] = 50;
				outSlowJ[i] = 50;
			}
		}
		List<KDJ> kdj = vo.getKdj();
		kdj.clear();

		for (int i = 0; i < outSlowK.length; i++) {
			double k = outSlowK[i];
			double d = outSlowD[i];
			double j = outSlowJ[i];
			kdj.add(new KDJ(k, d, j));
		}
		vo.setKdj(kdj);
	}

	private static double getBigDecimail(double d) {
		if (Double.isInfinite(d) || Double.isNaN(d)) {
			return d;
		}
		return getDouble(d);
	}

	private static double getDouble(double d) {
		return new BigDecimal(d).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}


}

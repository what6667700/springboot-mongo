package com.dc.handle;

import com.dc.model.HistorytradeInfo;
import com.dc.model.pojo.kdj.KdjNorm;
import com.dc.model.pojo.macd.MacdNorm;
import com.dc.model.vo.StrategyVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculateHandle {
	public static boolean init_all = false;

	public static void handle(HistorytradeInfo stockHistory) {
			StrategyVo vo =new StrategyVo();
			vo.getStockHistories().add(stockHistory);
			if (vo.getStockHistories().size() < 30) {
				return;
			}
			// macd指标
			MacdNorm.getInstance().handle(vo);
			// kdj指标
			KdjNorm.getInstance().handle(vo);
	}
}

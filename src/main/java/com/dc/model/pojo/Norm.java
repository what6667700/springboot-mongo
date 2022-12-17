package com.dc.model.pojo;


import com.dc.model.vo.StrategyVo;

import java.math.BigDecimal;

/**
 * 指标
 * 
 * @author Administrator
 *
 */
public interface Norm {
	void handle(StrategyVo vo);

	default double getDouble(double d) {
		return new BigDecimal(d).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}
}

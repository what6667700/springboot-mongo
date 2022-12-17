package com.dc.job;


import com.dc.dal.HistorytradeInfoRepository;
import com.dc.dal.StockCodeRepository;
import com.dc.handle.CalculateHandle;
import com.dc.model.HistorytradeInfo;
import com.dc.model.StockCode;
import com.dc.model.vo.StrategyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

@Slf4j
@Component
public class StockJob implements ApplicationRunner {

	@Autowired
	private StockCodeRepository stockCodeRepository;

	@Autowired
	private HistorytradeInfoRepository historytradeInfoRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<StockCode> stockCodes = stockCodeRepository.findAll();

		stockCodes.parallelStream().forEach(stockCode -> {
			StrategyVo vo = new StrategyVo();
			vo.setCode(stockCode.getCODE());
			List<HistorytradeInfo> stockHistories  = null;
			try {
				stockHistories = historytradeInfoRepository.findHistorytradeInfo(stockCode.getCODE(),"","");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (CollectionUtils.isNotEmpty(stockHistories)) {
				for (HistorytradeInfo stockHistory : stockHistories) {
					CalculateHandle.handle(stockHistory);
				}
			}
			vo.setInit(true);
		});
	}
}

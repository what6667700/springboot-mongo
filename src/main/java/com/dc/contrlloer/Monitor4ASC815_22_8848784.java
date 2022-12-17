package com.dc.contrlloer;

import com.dc.dal.*;
import com.dc.model.*;
import com.dc.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Monitor4ASC815_22_8848784 {
	@Autowired
	private StockCodeRepository stockCodeRepository;
	

	@Autowired
	private ScpoolRepository scpoolRepository;

	@Autowired
	private HistorytradeInfoRepository historytradeInfoRepository;
	
	@Autowired
	private Helper helper;

	public List<StockCode> getFinal(String endDateStr) throws Exception
	{
		
		List<StockCode> Results = new ArrayList();
		
		SimpleDateFormat format =  new SimpleDateFormat( "yyyyMMdd");
		
//		String startDate100DaysBeforeStr = helper.getStartDateStr100DaysBefore(endDateStr); // 要当天
		String startDate100DaysBeforeStr = helper.getStartDateStr15daysBefore(endDateStr,-20); // 要当天
		List<String> monitors = new ArrayList<>();
		monitors.add("88784");
		List<Scpool> scLst = scpoolRepository.findAllScpoolGteEndDateStr(startDate100DaysBeforeStr,endDateStr,true,monitors);

		for (Scpool scpool : scLst) {
			int sore = 0;
			String createDate = scpool.getCreateTime();
			String code = scpool.getCode();
			if(code!=null && code.length()>1){

			}else{
//				profitability profitability = profitabilityRepository.findOrderReqByName(stockbasics.getName());
				continue;
			}

			String codeStr  = scpool.getCode().substring(0, 3);
			if(codeStr.equals("900")||codeStr.equals("200")){
				continue;
			}

			if(scpool!=null)
			{
				boolean PERCENTASC = true;
				
				// 1 天 当天
				List<HistorytradeInfo> resultList2Days  = historytradeInfoRepository.findHistorytradeInfoByDesc4MA30_MA60(scpool.getCode(), startDate100DaysBeforeStr, endDateStr);
				if(resultList2Days==null 
						|| resultList2Days.size()<=20
						|| resultList2Days.get(0)==null 
						|| resultList2Days.get(0).getTrade_date()==null
						|| !resultList2Days.get(0).getTrade_date().equals(endDateStr)){
					continue;
				}


				HistorytradeInfo historytradeInfoDay0 = resultList2Days.get(0);
				double createVol = 0.0;
				for(HistorytradeInfo historytradeInfo : resultList2Days ){
				      if(historytradeInfo.getTrade_date().equals(createDate)){
				      	   createVol = historytradeInfo.getVol();
					  }
				}

				if(historytradeInfoDay0.getVol()<createVol){
					PERCENTASC = false;
					break;
				}

				if(PERCENTASC)
				{
					StockCode result = new StockCode();
					result.setSYMBOL(scpool.getCode());

					result.setNAME(scpool.getName());
					result.setCODE(scpool.getCode());
					result.setPE(scpool.getMonitor());
					result.setVOLUME(scpool.getCreateTime());
					result.setMFRATIO2(scpool.getCreateTime());
					result.setPROFIT(sore+"");
					Results.add(result);
				}

			}
		}
		
		
		System.out.println(">>>>>>>>>>>>>>>>>> result.size="+Results.size());
		for (StockCode result : Results) {
			System.out.println("Code:"+result.getSYMBOL()+"  name:"+result.getNAME()+ "   monitor:"+result.getPE()
			+"   createTime:"+result.getVOLUME()+ "    sore:"+result.getPROFIT()+ "    lowestPriceDays:"+result.getSYMBOL());
			        Scpool scpool = new Scpool(result.getNAME(),result.getSYMBOL(), "8848784",endDateStr,"",0.0);
					scpoolRepository.save(scpool);

		}
		
		
		return Results;
	}
	
//	@Scheduled(cron = "0 37 20 3 * ?")
	// middle and small 
	public List<StockCode> firstStrategy() throws Exception
	{
		List<StockCode> queryResults = null;
			queryResults = stockCodeRepository.findAllOrderReq();
		return queryResults;
	}
	
	// big 
	public List<StockCode> secondStrategy() throws Exception
	{
		List<StockCode> Results = new ArrayList();
		try {
			List<StockCode> queryResults = stockCodeRepository.findAllOrderReq();
			
			for (StockCode result : queryResults) {
				if(Results.size()<100)
				{
					if(result.getMFRATIO2()!=null && result.getMFRATIO2().indexOf(".")>0
							&& result.getMCAP()!=null && result.getMCAP().indexOf(".")>0
							&& result.getPE()!=null && result.getPE().indexOf(".")>0){
						if(Double.parseDouble(result.getMFRATIO2())>0)
						{
							if(Double.parseDouble(result.getMCAP())>50000000000.00 
									&& Double.parseDouble(result.getPE())<30)
							{
								Results.add(result);
								//System.out.println("Code:"+result.getCode()+"  name:"+result.getName()+ "   PE:"+result.getPE()+"   MFRATIO2:"+result.getMFRATIO2());
							}
						}
					}else
					{
						continue;
					}
					
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally
		{}
		return Results;
	}

}

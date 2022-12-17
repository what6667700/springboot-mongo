package com.dc.contrlloer;


import com.dc.dal.*;
import com.dc.model.*;
import com.dc.utils.Helper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;

@RestController
@RequestMapping("/monitor88884")
public class Monitor4ASC815_22_88884 {
	@Autowired
	private StockCodeRepository stockCodeRepository;

	@Autowired
	private StockjjcgphRepository stockjjcgphRepository;

	@Autowired
	private ScpoolRepository scpoolRepository;

	@Autowired
	private StkdjRepository stkdjRepository;

	@Autowired
	private HistorytradeInfoRepository historytradeInfoRepository;

	@Autowired
	private Helper2 helper;
	
	public List<StockCode> getFinal(String endDateStr) throws Exception
	{
		
		List<StockCode> Results = new ArrayList();
		
		List<Stockjjcgph> sCode = firstStrategy();


		SimpleDateFormat format =  new SimpleDateFormat( "yyyyMMdd");
		
		String startDate100DaysBeforeStr = helper.getStartDateStr360DaysBefore(endDateStr); // 要当天
		
		for (Stockjjcgph stockjjcgph : sCode) {
			int sore = 0;
			String code = stockjjcgph.getSYMBOL();
			if(code!=null && code.length()>1){

			}else{
				continue;
			}

			String codeStr  = stockjjcgph.getSYMBOL().substring(0, 3);
			if(codeStr.equals("900")||codeStr.equals("200")){
				continue;
			}

			if(stockjjcgph!=null)
			{
				boolean PERCENTASC = true;
				
				// 1 天 当天
				List<HistorytradeInfo> resultList2Days  = historytradeInfoRepository.findHistorytradeInfoByDesc4MA30_MA60(stockjjcgph.getSYMBOL(), startDate100DaysBeforeStr, endDateStr);
				HistorytradeInfo historytradeInfoHighestDay =  helper.computeHighestHighPrice4kdj4Obj(resultList2Days,60);
				if(historytradeInfoHighestDay!=null&& historytradeInfoHighestDay.getTrade_date()!=null) {

					String trade_date = historytradeInfoHighestDay.getTrade_date();
					DateFormat df = new SimpleDateFormat("yyyyMMdd");

					Date date = df.parse(trade_date);
					Date dateDangDay = df.parse(endDateStr);


					long daysHighest = (dateDangDay.getTime() - date.getTime()) / 1000 / 3600 / 24;
					if(daysHighest<50){
						continue;
					}

				}



				if(resultList2Days.size()<250){
					continue;
				}


				if(resultList2Days==null
						|| resultList2Days.size()<=20
						|| resultList2Days.get(0)==null 
						|| resultList2Days.get(0).getTrade_date()==null
						|| !resultList2Days.get(0).getTrade_date().equals(endDateStr)){
					continue;
				}

				double highest = helper.computeHighestHighPrice4kdj(resultList2Days,50);
				double lowest  = helper.computeLowestLowPrice4kdj(resultList2Days,50);
				double percentLow =((lowest - highest)/highest)*100;
				if(percentLow>-20){
					continue;
				}

				int days4His = 0;
				double previousDaysMa240 = 0.0;
				double previousDaysMa120 = 0.0;
				double pct_change_total = 0.0;
				for(HistorytradeInfo historytradeInfo : resultList2Days ){
					if(days4His==10){
						break;
					}

					boolean isNeedUpdate = false;

					String newEndDate = historytradeInfo.getTrade_date();


					if(historytradeInfo.getMa60()==0.0){
						String newStartDate = helper.getStartDateStr360DaysBefore(newEndDate); // 要当天
						List<HistorytradeInfo> newResultList2Days  = historytradeInfoRepository.findHistorytradeInfoByDesc4MA30_MA60(stockjjcgph.getSYMBOL(), newStartDate, newEndDate);

						if(newResultList2Days.size()<250){
							continue;
						}

						if(historytradeInfo.getMa5()==0.0){
							double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 5);
							BigDecimal b60 = new BigDecimal(day1MA30);
							day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setMa5(day1MA30);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getMa10()==0.0){
							double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 10);
							BigDecimal b60 = new BigDecimal(day1MA30);
							day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setMa10(day1MA30);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getMa20()==0.0){
							double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 20);
							BigDecimal b60 = new BigDecimal(day1MA30);
							day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setMa20(day1MA30);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getMa30()==0.0){
							double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 30);
							BigDecimal b60 = new BigDecimal(day1MA30);
							day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setMa30(day1MA30);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getMa60()==0.0){
							double day1MA60 = helper.computeMA30_MA60(newResultList2Days, 60);
							BigDecimal b60 = new BigDecimal(day1MA60);
							day1MA60 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setMa60(day1MA60);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getMa120()==0.0){
							double day1MA120 = helper.computeMA30_MA60(newResultList2Days, 120);
							BigDecimal b120 = new BigDecimal(day1MA120);
							day1MA120 = b120.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setMa120(day1MA120);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getMa240()==0.0){
							double day1MA250 = helper.computeMA30_MA60(newResultList2Days, 250);
							BigDecimal b250 = new BigDecimal(day1MA250);
							day1MA250 = b250.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setMa240(day1MA250);
							isNeedUpdate = true;
						}


						if(historytradeInfo.getV_ma5()==0.0){
							double day1MA30 = helper.computeVMA30_MA60(newResultList2Days, 5);
							BigDecimal b60 = new BigDecimal(day1MA30);
							day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setV_ma5(day1MA30);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getV_ma10()==0.0){
							double day1MA30 = helper.computeVMA30_MA60(newResultList2Days, 10);
							BigDecimal b60 = new BigDecimal(day1MA30);
							day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setV_ma10(day1MA30);
							isNeedUpdate = true;
						}

						if(historytradeInfo.getV_ma20()==0.0){
							double day1MA30 = helper.computeVMA30_MA60(newResultList2Days, 20);
							BigDecimal b60 = new BigDecimal(day1MA30);
							day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							historytradeInfo.setV_ma20(day1MA30);
							isNeedUpdate = true;
						}

						if(isNeedUpdate){
							historytradeInfoRepository.updateHistorytradeInfoMA120_MA240ById(historytradeInfo);
						}
					}

					pct_change_total += historytradeInfo.getP_change();

					// clsoe > 所有均线
					if(days4His==0){

						if(historytradeInfo.getPct_chg()<9.0 || historytradeInfo.getPct_chg() > 15){
							PERCENTASC = false;
							break;
						}

					}else{

						if(historytradeInfo.getPct_chg()>9.0){
							PERCENTASC = false;
							break;
						}

						if(days4His==3 && pct_change_total>15){
							PERCENTASC = false;
							break;
						}

					}

					days4His++;

				}

				if(!PERCENTASC)
				{
					continue;
				}

				HistorytradeInfo historytradeInfo = resultList2Days.get(0);


				String startDate = helper.getStartDateStr70daysBefore(historytradeInfo.getTrade_date());
				List<Stkdj> queryResults = stkdjRepository.findSTKDJByCodeAndBeforeDate(historytradeInfo.getTs_code(), historytradeInfo.getTrade_date(),startDate);

				if(queryResults==null
						|| queryResults.size()<=20){
					continue;
				}
				int days = 0;
				double bollMidPrevious = 0.0;
				double p_change_total = 0.0;

				double closePrevious = 0.0;
				double highPrevious = 0.0;
				double lowPrevious = 0.0;

				boolean isFirstKDJGolden = false;
				boolean isTG = false;
				boolean isBoolUpDown = false;
				boolean isBelowMiddle = false;

				int aboveBollUpDays = 0;
				for(Stkdj stkdj : queryResults ){
					if(days==1){
						break;
					}

					if(days==0){

						if(stkdj.getLow()<=stkdj.getBoll()){
							isBelowMiddle = true;
						}

						if(!stkdj.getTrade_date().equals(endDateStr)){
							PERCENTASC = false;
							break;
						}

                        if(

                        		stkdj.getMacds() >= 0.001

						){
                            PERCENTASC = false;
                            break;
                        }

						p_change_total += stkdj.getPct_chg();

						bollMidPrevious = stkdj.getBoll();

						closePrevious = stkdj.getClose();
						highPrevious = stkdj.getHigh();
						lowPrevious = stkdj.getLow();

						if(stkdj.getLow()<stkdj.getBoll_lb() && stkdj.getHigh()>stkdj.getBoll_ub()){
							isBoolUpDown = true;
						}

						
					}else{

						if(days==1){

							if(!isBelowMiddle){
								if(stkdj.getLow()<=stkdj.getBoll()){
									isBelowMiddle = true;
								}
							}

							p_change_total += stkdj.getPct_chg();
							if(p_change_total>20){
								PERCENTASC = false;
								break;
							}

							if(bollMidPrevious<=stkdj.getBoll()){
								PERCENTASC = false;
								break;
							}

							if(stkdj.getKdjj() < stkdj.getKdjd()
									&& stkdj.getKdjk() < stkdj.getKdjd()){
								isFirstKDJGolden = true;
							}

							// 跳空高开
							if(stkdj.getHigh() < lowPrevious ){
								isTG = true;
							}

						}

						if(isFirstKDJGolden && days>1 && days<7){
							if(stkdj.getKdjj() < stkdj.getKdjd()
									&& stkdj.getKdjk() < stkdj.getKdjd()){
								isFirstKDJGolden = true;
							}else{
								isFirstKDJGolden = false;
							}
						}

                        if(stkdj.getHigh()>stkdj.getBoll_ub() ){
								PERCENTASC = false;
								break;
                        }

					}
					
					days++;
				}

				if(isFirstKDJGolden){
					sore += 10000;
				}

				// 跳空高开
				if(isTG){
					sore += 10000;
				}

				if(isBoolUpDown){
					sore += 10000;
				}
				if(PERCENTASC)
				{

					StockCode result = new StockCode();
					result.setSYMBOL(stockjjcgph.getSYMBOL());

					result.setNAME(stockjjcgph.getSNAME());
					result.setCODE(stockjjcgph.getSYMBOL());
					result.setPE(stockjjcgph.getSHULIANG()+"");
					result.setVOLUME(stockjjcgph.getSCSTC27()+"");
					result.setMFRATIO2(stockjjcgph.getGUSHU()+"");
					result.setPROFIT(sore+"");
					Results.add(result);


				}
				
				
			}
		}
		
		
		System.out.println(">>>>>>>>>>>>>>>>>> result.size="+Results.size());
		for (StockCode result : Results) {
			System.out.println("Code:"+result.getSYMBOL()+"  name:"+result.getNAME()+ "   PE:"+result.getPE()
			+"   MFRATIO2:"+result.getMFRATIO2()+ "    sore:"+result.getPROFIT()+ "    lowestPriceDays:"+result.getSYMBOL());
			    String endDate100DaysAfterStr = helper.getStartDateStr360DaysAfter(endDateStr); // 要当天
			    List<HistorytradeInfo> resultList2Days = historytradeInfoRepository.findHistorytradeInfo2(result.getSYMBOL(),endDateStr,endDate100DaysAfterStr);
			    if(resultList2Days!=null && resultList2Days.size()>0){
					HistorytradeInfo historytradeInfo = resultList2Days.get(0);
					Scpool scpool = new Scpool(result.getNAME(),result.getSYMBOL(), "88884",endDateStr,historytradeInfo.getTrade_date(),historytradeInfo.getOpen());
					scpoolRepository.save(scpool);
			    }
//			}
			
			
		}
		
		
		return Results;
	}
	
	
	
	
//	@Scheduled(cron = "0 37 20 3 * ?")
	// middle and small 
	public List<Stockjjcgph> firstStrategy() throws Exception
	{
		List<Stockjjcgph> Results = new ArrayList();
		List<Stockjjcgph> queryResults = null;
			queryResults = stockjjcgphRepository.findStockjjcgph();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{}
		return Results;
	}

}

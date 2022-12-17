package com.dc.contrlloer;


import com.dc.dal.*;
import com.dc.model.*;
import com.dc.utils.Helper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("strategy")
public class Monitor4ASC815_22_881 {
	@Autowired
	private StockCodeRepository stockCodeRepository;

	@Autowired
	private ScpoolRepository scpoolRepository;

	@Autowired
	private StkdjRepository stkdjRepository;

	@Autowired
	private HistorytradeInfoRepository historytradeInfoRepository;

	@Autowired
	private Helper2 helper;

	@RequestMapping(value = "/monitor881",method = RequestMethod.POST)
	public List<StockCode> getFinal(String endDateStr) throws Exception
	{

		List<StockCode> Results = new ArrayList();

		List<StockCode> sCode = firstStrategy();

		String startDate100DaysBeforeStr = helper.getStartDateStr360DaysBefore(endDateStr); // 要当天

		for (StockCode stockbasics : sCode) {
			int sore = 0;
			String code = stockbasics.getSYMBOL();
			if(code!=null && code.length()>1){

			}else{
				continue;
			}

			String codeStr  = stockbasics.getSYMBOL().substring(0, 3);
			if(codeStr.equals("900")||codeStr.equals("200")){
				continue;
			}

			if(stockbasics!=null)
			{
				boolean PERCENTASC = true;
				// 1 天 当天

				List<HistorytradeInfo> resultList2Days  = historytradeInfoRepository.findHistorytradeInfoByDesc4MA30_MA60(stockbasics.getSYMBOL(), startDate100DaysBeforeStr, endDateStr);

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

				int days4His = 0;
				double previousDaysMa240 = 0.0;
				double previousDaysMa60 = 0.0;
				double secClose = 0.0;
				for(HistorytradeInfo historytradeInfo : resultList2Days ){
					if(days4His==10){
						break;
					}

					boolean isNeedUpdate = false;

					String newEndDate = historytradeInfo.getTrade_date();
					if(historytradeInfo.getV_ma5()==0.0){
						String newStartDate = helper.getStartDateStr360DaysBefore(newEndDate); // 要当天
						List<HistorytradeInfo> newResultList2Days  = historytradeInfoRepository.findHistorytradeInfoByDesc4MA30_MA60(stockbasics.getSYMBOL(), newStartDate, newEndDate);

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

					if(days4His==0){
						previousDaysMa240 = historytradeInfo.getMa240();
						previousDaysMa60 = historytradeInfo.getMa60();
					}else{
						if(previousDaysMa240>=historytradeInfo.getMa240() ){
							previousDaysMa240 = historytradeInfo.getMa240();
						}else{
							PERCENTASC = false;
							break;
						}
						if(days4His==1){
						}
					}

					// clsoe > 所有均线
					if(days4His==0){
						if(historytradeInfo.getClose()>historytradeInfo.getMa5() &&
								historytradeInfo.getClose()>historytradeInfo.getMa10()
								&& historytradeInfo.getClose()>historytradeInfo.getMa20()
							    && historytradeInfo.getClose()>historytradeInfo.getMa30()

								&& historytradeInfo.getClose()>=historytradeInfo.getMa120()
						        && historytradeInfo.getClose()>=historytradeInfo.getMa240()
								&& historytradeInfo.getPct_chg()>3.8

						){
							sore += 10000;
						}else{
							PERCENTASC = false;
							break;
						}



						double ration = historytradeInfo.getVol()/historytradeInfo.getV_ma5();
						if(ration>=1.8 && ration<3){

						}else{
							PERCENTASC = false;
							break;
						}

					}

					if(days4His>0){
						double ration = historytradeInfo.getVol()/historytradeInfo.getV_ma5();
						if(ration>=1.6){
							PERCENTASC = false;
							break;
						}

						if(historytradeInfo.getPct_chg()>5 || historytradeInfo.getPct_chg()<-5){
							PERCENTASC = false;
							break;
						}

						if(days4His==1){
							secClose = historytradeInfo.getClose();
						}
						if(days4His==9){
							double priceChange = ((secClose - historytradeInfo.getClose()) / historytradeInfo.getClose())*100;
							if(priceChange>10){
								PERCENTASC = false;
								break;
							}
						}
					}


					days4His++;

				}

				if(!PERCENTASC)
				{
					continue;
				}

				HistorytradeInfo historytradeInfo = resultList2Days.get(0);
				String startDate = helper.getStartDateStr60daysBefore(historytradeInfo.getTrade_date());
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

				for(Stkdj stkdj : queryResults ){
					if(days==40){
						break;
					}


					if(days==0){


						if(!stkdj.getTrade_date().equals(endDateStr)){
							PERCENTASC = false;
							break;
						}

                        if(
                        		stkdj.getMacds() >= -0.01
								|| stkdj.getMacdh() < 0
								|| stkdj.getMacd() < stkdj.getMacds()
								|| stkdj.getHigh() < stkdj.getBoll_ub()
								|| stkdj.getKdjj() < stkdj.getKdjd()
								|| stkdj.getKdjk() < stkdj.getKdjd()
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
							p_change_total += stkdj.getPct_chg();
							if(p_change_total>20){
								PERCENTASC = false;
								break;
							}

							if(bollMidPrevious<stkdj.getBoll()){
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

                        if(stkdj.getHigh()>=stkdj.getBoll_ub()){
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
					result.setSYMBOL(stockbasics.getSYMBOL());
					result.setNAME(stockbasics.getNAME());
					result.setCODE(stockbasics.getSYMBOL());
					result.setPE(stockbasics.getPE()+"");
					result.setVOLUME(stockbasics.getTURNOVER()+"");
					result.setMFRATIO2(stockbasics.getPROFIT()+"");
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
					Scpool scpool = new Scpool(result.getNAME(),result.getSYMBOL(), "881",endDateStr,historytradeInfo.getTrade_date(),historytradeInfo.getOpen());
					scpoolRepository.save(scpool);
			    }
		}
		return Results;
	}

	public List<StockCode> firstStrategy() throws Exception
	{
		List<StockCode> queryResults = stockCodeRepository.findAllOrderReq();
		return queryResults;
	}

}

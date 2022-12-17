package com.dc.multi.business;

import com.dc.dal.HistorytradeInfoRepository;
import com.dc.dal.ScpoolRepository;
import com.dc.dal.StkdjRepository;
import com.dc.dal.StockCodeRepository;
import com.dc.model.HistorytradeInfo;
import com.dc.model.Scpool;
import com.dc.model.Stkdj;
import com.dc.model.StockCode;
import com.dc.utils.Helper;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Strategy781Task implements Runnable{

    private String taskInDate;

    public Strategy781Task(String taskInDate, StockCodeRepository stockCodeRepository, ScpoolRepository scpoolRepository, StkdjRepository stkdjRepository, HistorytradeInfoRepository historytradeInfoRepository, Helper helper) {
        super();
        this.taskInDate = taskInDate;
        this.stockCodeRepository = stockCodeRepository;
        this.scpoolRepository = scpoolRepository;
        this.stkdjRepository = stkdjRepository;
        this.historytradeInfoRepository = historytradeInfoRepository;
        this.helper = helper;
    }

    private StockCodeRepository stockCodeRepository;

    private ScpoolRepository scpoolRepository;

    private StkdjRepository stkdjRepository;

    private HistorytradeInfoRepository historytradeInfoRepository;

    private Helper helper;

    @SneakyThrows
    @Override
    public void run() {

        List<StockCode> results = new ArrayList();

        List<StockCode> sCode = stockCodeRepository.findAllOrderReq();

        String endDateStr = taskInDate;


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
                double previousDaysMa120 = 0.0;
                double previousDaysMa60 = 0.0;
                for(HistorytradeInfo historytradeInfo : resultList2Days ){
                    if(days4His==5){
                        break;
                    }

                    boolean isNeedUpdate = false;

                    String newEndDate = historytradeInfo.getTrade_date();


                    if(historytradeInfo.getMa60()==0.0){
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
                        previousDaysMa120 = historytradeInfo.getMa120();

                    }else if(days4His==1){
                        if(previousDaysMa240>=historytradeInfo.getMa240()
                        ){
                            previousDaysMa240 = historytradeInfo.getMa240();
                        }else{
                            PERCENTASC = false;
                            break;
                        }
                    }

                    // clsoe > 所有均线
                    if(days4His==0){
                        previousDaysMa60 = historytradeInfo.getMa60();

                        if(historytradeInfo.getMa60()< historytradeInfo.getMa240()){
                            PERCENTASC = false;
                            break;
                        }

                        if(historytradeInfo.getPct_chg()<6.0){
                            PERCENTASC = false;
                            break;
                        }

                        if(
                                historytradeInfo.getClose()>historytradeInfo.getMa60()
                        ){
                            sore += 10000;
                        }else{
                            PERCENTASC = false;
                            break;
                        }

                        if(historytradeInfo.getHigh()/historytradeInfo.getClose() > 1.019){
                            PERCENTASC = false;
                            break;
                        }

                        if(historytradeInfo.getVol()<historytradeInfo.getV_ma5()*1.9 || historytradeInfo.getVol()>historytradeInfo.getV_ma5()*2.76){
                            PERCENTASC = false;
                            break;
                        }
                    }else{

                        if(days4His<=2){
                            if(previousDaysMa60 < historytradeInfo.getMa60()){
                                PERCENTASC = false;
                                break;
                            } else {
                                previousDaysMa60 = historytradeInfo.getMa60();
                            }


                        }

                        if(historytradeInfo.getPct_chg()>3 || historytradeInfo.getPct_chg()<-3){
                            PERCENTASC = false;
                            break;
                        }

                        if(historytradeInfo.getVol()>historytradeInfo.getV_ma5()*1.5 || historytradeInfo.getVol()<historytradeInfo.getV_ma5()*0.5){
                            PERCENTASC = false;
                            break;
                        }
                    }

                    days4His++;
//					PERCENTASC = false;

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
                boolean isBelowMiddle = false;

                double macdsPrevious = 0.0;

                int aboveBollUpDays = 0;
                for(Stkdj stkdj : queryResults ){
                    if(days==20){
                        break;
                    }

                    if(days==0){

                        macdsPrevious = stkdj.getMacds();

                        if(stkdj.getLow()<=stkdj.getBoll()){
                            isBelowMiddle = true;
                        }


                        if(!stkdj.getTrade_date().equals(endDateStr)){
                            PERCENTASC = false;
                            break;
                        }

                        if(

                                stkdj.getMacds() >= 0.1
//								|| stkdj.getMacdh() < 0
                                        || stkdj.getMacd() < stkdj.getMacds()
                                        || stkdj.getHigh() < stkdj.getBoll_ub()
                                        || stkdj.getKdjj() < stkdj.getKdjd()
                                        || stkdj.getKdjk() < stkdj.getKdjd()
                                        || stkdj.getClose() < stkdj.getMa5()
                                        || stkdj.getClose() < stkdj.getMa10()
                                        || stkdj.getVol() < (stkdj.getV_ma5()*1.8)


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
                            if(p_change_total>15){
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

                        if(days<2){
                            // macd顶背离
                            if(macdsPrevious<stkdj.getMacds()){
                                PERCENTASC = false;
                                break;
                            }else {
                                macdsPrevious = stkdj.getMacds();
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
                    results.add(result);
                }
            }
        }

        System.out.println(">>>>>>>>>>>>>>>>>> result.size="+results.size());
        for (StockCode result : results) {
            System.out.println("Code:"+result.getSYMBOL()+"  name:"+result.getNAME()+ "   PE:"+result.getPE()
                    +"   MFRATIO2:"+result.getMFRATIO2()+ "    sore:"+result.getPROFIT()+ "    lowestPriceDays:"+result.getSYMBOL());
            Scpool scpool = new Scpool(result.getNAME(),result.getSYMBOL(), "88781",endDateStr,"",0.0);
            scpoolRepository.save(scpool);
        }

    }
}

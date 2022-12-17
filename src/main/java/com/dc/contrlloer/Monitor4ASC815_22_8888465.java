package com.dc.contrlloer;

import com.dc.dal.*;
import com.dc.model.*;
import com.dc.utils.Helper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Monitor4ASC815_22_8888465 {
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

    public List<StockCode> getFinal(String endDateStr) throws Exception {

        List<StockCode> Results = new ArrayList();

        List<StockCode> sCode = this.firstStrategy();

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        String startDate100DaysBeforeStr = helper.getStartDateStr360DaysBefore(endDateStr); // 要当天

        for (StockCode stockjjcgph : sCode) {
            int sore = 0;
            String code = stockjjcgph.getSYMBOL();
            if (code != null && code.length() > 1) {

            } else {
                continue;
            }

            String codeStr = stockjjcgph.getSYMBOL().substring(0, 3);
            if (codeStr.equals("900") || codeStr.equals("200")) {
                continue;
            }

            if (stockjjcgph != null) {
                boolean PERCENTASC = true;

                // 1 天 当天
                List<HistorytradeInfo> resultList2Days = historytradeInfoRepository.findHistorytradeInfoByDesc4MA30_MA60(stockjjcgph.getSYMBOL(), startDate100DaysBeforeStr, endDateStr);
                HistorytradeInfo historytradeInfoHighestDay = helper.computeHighestHighPriceClose4kdj4Obj(resultList2Days, 60);
                if (historytradeInfoHighestDay != null && historytradeInfoHighestDay.getTrade_date() != null) {
                    if (!historytradeInfoHighestDay.getTrade_date().equals(endDateStr)) {
                        continue;
                    }
                }

                HistorytradeInfo historytradeInfoHighestVolDay = helper.computeHighestHighVol4kdj4Obj(resultList2Days, 200);

                if (historytradeInfoHighestVolDay != null && historytradeInfoHighestVolDay.getTrade_date() != null) {
                    if (historytradeInfoHighestVolDay.getTrade_date().equals(endDateStr)) {
//						continue;
                    }
                }


                if (resultList2Days.size() < 250) {
                    continue;
                }


                if (resultList2Days == null
                        || resultList2Days.size() <= 20
                        || resultList2Days.get(0) == null
                        || resultList2Days.get(0).getTrade_date() == null
                        || !resultList2Days.get(0).getTrade_date().equals(endDateStr)) {
                    continue;
                }

                double highestBefore1Day = helper.computeHighestClosePriceBefore1Day4kdj(resultList2Days, 9);
                double lowestBefore1Day = helper.computeLowestClosePriceBefore1Day4kdj(resultList2Days, 9);
                double percentLowBefore1Day = ((highestBefore1Day - lowestBefore1Day) / lowestBefore1Day) * 100;
                if (percentLowBefore1Day > 10.99) {
                    continue;
                }

                double highest = helper.computeHighestClosePrice4kdj(resultList2Days, 20);
                double lowest = helper.computeLowestClosePrice4kdj(resultList2Days, 20);
                double percentLow = ((highest - lowest) / lowest) * 100;
                if (percentLow > 37) {
                    continue;
                }

                int days4His = 0;
                int countPingHing = 0;
                double previousDaysMa240 = 0.0;
                double previousDaysMa120 = 0.0;
                double previousDaysMa60 = 0.0;
                double pct_change_total = 0.0;
                boolean isAboveMa240 = false;

                for (HistorytradeInfo historytradeInfo : resultList2Days) {
                    if (days4His == 10) {
                        break;
                    }

                    boolean isNeedUpdate = false;

                    String newEndDate = historytradeInfo.getTrade_date();


                    if (historytradeInfo.getMa60() == 0.0) {
                        String newStartDate = helper.getStartDateStr360DaysBefore(newEndDate); // 要当天
                        List<HistorytradeInfo> newResultList2Days = historytradeInfoRepository.findHistorytradeInfoByDesc4MA30_MA60(stockjjcgph.getSYMBOL(), newStartDate, newEndDate);

                        if (newResultList2Days.size() < 250) {
                            continue;
                        }

                        if (historytradeInfo.getMa5() == 0.0) {
                            double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 5);
                            BigDecimal b60 = new BigDecimal(day1MA30);
                            day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setMa5(day1MA30);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getMa10() == 0.0) {
                            double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 10);
                            BigDecimal b60 = new BigDecimal(day1MA30);
                            day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setMa10(day1MA30);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getMa20() == 0.0) {
                            double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 20);
                            BigDecimal b60 = new BigDecimal(day1MA30);
                            day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setMa20(day1MA30);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getMa30() == 0.0) {
                            double day1MA30 = helper.computeMA30_MA60(newResultList2Days, 30);
                            BigDecimal b60 = new BigDecimal(day1MA30);
                            day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setMa30(day1MA30);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getMa60() == 0.0) {
                            double day1MA60 = helper.computeMA30_MA60(newResultList2Days, 60);
                            BigDecimal b60 = new BigDecimal(day1MA60);
                            day1MA60 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setMa60(day1MA60);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getMa120() == 0.0) {
                            double day1MA120 = helper.computeMA30_MA60(newResultList2Days, 120);
                            BigDecimal b120 = new BigDecimal(day1MA120);
                            day1MA120 = b120.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setMa120(day1MA120);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getMa240() == 0.0) {
                            double day1MA250 = helper.computeMA30_MA60(newResultList2Days, 250);
                            BigDecimal b250 = new BigDecimal(day1MA250);
                            day1MA250 = b250.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setMa240(day1MA250);
                            isNeedUpdate = true;
                        }


                        if (historytradeInfo.getV_ma5() == 0.0) {
                            double day1MA30 = helper.computeVMA30_MA60(newResultList2Days, 5);
                            BigDecimal b60 = new BigDecimal(day1MA30);
                            day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setV_ma5(day1MA30);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getV_ma10() == 0.0) {
                            double day1MA30 = helper.computeVMA30_MA60(newResultList2Days, 10);
                            BigDecimal b60 = new BigDecimal(day1MA30);
                            day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setV_ma10(day1MA30);
                            isNeedUpdate = true;
                        }

                        if (historytradeInfo.getV_ma20() == 0.0) {
                            double day1MA30 = helper.computeVMA30_MA60(newResultList2Days, 20);
                            BigDecimal b60 = new BigDecimal(day1MA30);
                            day1MA30 = b60.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            historytradeInfo.setV_ma20(day1MA30);
                            isNeedUpdate = true;
                        }

                        if (isNeedUpdate) {
                            historytradeInfoRepository.updateHistorytradeInfoMA120_MA240ById(historytradeInfo);
                        }
                    }

                    // clsoe > 所有均线
                    if (days4His == 0) {

                        if (codeStr.equals("300") || codeStr.equals("688")) {
                            if (historytradeInfo.getPct_chg() < 19) {
                                PERCENTASC = false;
                                break;
                            }
                        } else {
                            if (historytradeInfo.getPct_chg() < 9.17) {
                                PERCENTASC = false;
                                break;
                            }
                        }

                        if (historytradeInfo.getClose() > historytradeInfo.getMa5() &&
                                historytradeInfo.getMa5() > historytradeInfo.getMa10()
                                && historytradeInfo.getMa10() > historytradeInfo.getMa20()
                                && historytradeInfo.getClose() > historytradeInfo.getMa30()
                                && historytradeInfo.getClose() > historytradeInfo.getMa60()
                                && historytradeInfo.getClose() > historytradeInfo.getMa120()
//						        && historytradeInfo.getClose()>historytradeInfo.getMa240()
                        ) {
                            sore += 10000;
                            if (historytradeInfo.getClose() > historytradeInfo.getMa240()) {
                                isAboveMa240 = true;
                            }
                        } else {
                            PERCENTASC = false;
                            break;
                        }

                        if (historytradeInfo.getVol() < historytradeInfo.getV_ma5() * 1.2 || historytradeInfo.getVol() > historytradeInfo.getV_ma5() * 4) {
                            PERCENTASC = false;
                            break;
                        }

                        previousDaysMa60 = historytradeInfo.getMa60();
                        previousDaysMa120 = historytradeInfo.getMa120();
                        previousDaysMa240 = historytradeInfo.getMa240();


                    } else {
                        if (historytradeInfo.getClose() > historytradeInfo.getMa5() &&
                                historytradeInfo.getMa5() > historytradeInfo.getMa10()
                                && historytradeInfo.getMa10() > historytradeInfo.getMa20()
                                && historytradeInfo.getClose() > historytradeInfo.getMa30()
                                && historytradeInfo.getClose() > historytradeInfo.getMa60()
                                && historytradeInfo.getClose() > historytradeInfo.getMa120()
                        ) {
                            if (isAboveMa240) {
                                if (historytradeInfo.getClose() > historytradeInfo.getMa240()) {
                                    PERCENTASC = false;
                                    break;
                                }
                            } else {
                                PERCENTASC = false;
                                break;
                            }

                        }
                        pct_change_total += historytradeInfo.getP_change();

                        if (historytradeInfo.getPct_chg() > 4.2 || historytradeInfo.getPct_chg() < -4.2) {
                            PERCENTASC = false;
                            break;
                        }

                        if (days4His == 3 && pct_change_total > 15) {
                            PERCENTASC = false;
                            break;
                        }

                    }

                    days4His++;

                }

                if (!PERCENTASC) {
                    continue;
                }

                HistorytradeInfo historytradeInfo = resultList2Days.get(0);


                String startDate = helper.getStartDateStr70daysBefore(historytradeInfo.getTrade_date());
                List<Stkdj> queryResults = stkdjRepository.findSTKDJByCodeAndBeforeDate(historytradeInfo.getTs_code(), historytradeInfo.getTrade_date(), startDate);


                if (queryResults == null
                        || queryResults.size() <= 20) {
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
                double macdslow = 0.0;
                for (Stkdj stkdj : queryResults) {
                    if (days == 3) {
                        break;
                    }

                    if (days == 0) {
                        macdslow = stkdj.getMacds();

                    } else {
                        if (days == 1 || days == 2) {
                            if (stkdj.getMacds() > macdslow) {
                                PERCENTASC = false;
                                break;
                            } else {
                                macdslow = stkdj.getMacds();
                            }
                        }
                    }
                    days++;
                }

                if (PERCENTASC) {
                    StockCode result = new StockCode();
                    result.setSYMBOL(stockjjcgph.getSYMBOL());

                    result.setNAME(stockjjcgph.getNAME());
                    result.setCODE(stockjjcgph.getSYMBOL());
                    result.setPE(stockjjcgph.getPE() + "");
                    result.setVOLUME(stockjjcgph.getTURNOVER() + "");
                    result.setMFRATIO2(stockjjcgph.getPROFIT() + "");
                    result.setPROFIT(sore + "");
                    Results.add(result);


                }


            }
        }


        System.out.println(">>>>>>>>>>>>>>>>>> result.size=" + Results.size());
        for (StockCode result : Results) {

            System.out.println("Code:" + result.getSYMBOL() + "  name:" + result.getNAME() + "   PE:" + result.getPE()
                    + "   MFRATIO2:" + result.getMFRATIO2() + "    sore:" + result.getPROFIT() + "    lowestPriceDays:" + result.getSYMBOL());
            Scpool scpool = new Scpool(result.getNAME(), result.getSYMBOL(), "8888465", endDateStr, "", 0.0);
            scpoolRepository.save(scpool);


        }


        return Results;

    }


    public List<StockCode> firstStrategy() throws Exception {
        List<StockCode> queryResults = null;
        try {


            queryResults = stockCodeRepository.findAllOrderReq();
        } catch (Exception e) {
        } finally {
        }
        return queryResults;
    }

    // big
    public List<StockCode> secondStrategy() throws Exception {
        List<StockCode> Results = new ArrayList();
        try {
            List<StockCode> queryResults = stockCodeRepository.findAllOrderReq();

            for (StockCode result : queryResults) {
                if (Results.size() < 100) {
                    if (result.getMFRATIO2() != null && result.getMFRATIO2().indexOf(".") > 0
                            && result.getMCAP() != null && result.getMCAP().indexOf(".") > 0
                            && result.getPE() != null && result.getPE().indexOf(".") > 0) {
                        if (Double.parseDouble(result.getMFRATIO2()) > 0) {
                            if (Double.parseDouble(result.getMCAP()) > 50000000000.00
                                    && Double.parseDouble(result.getPE()) < 30) {
                                Results.add(result);
                            }
                        }
                    } else {
                        continue;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return Results;
    }

}

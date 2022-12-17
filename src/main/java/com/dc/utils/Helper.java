package com.dc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.dc.dal.StockCodeRepository;
import com.dc.model.HistorytradeInfo;
import com.dc.model.StockCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Helper {
	
	@Autowired
	private StockCodeRepository stockCodeRepository;

	public String getStartDateStr70daysBefore(String endDateStr) throws ParseException
	{
		SimpleDateFormat format =  new SimpleDateFormat( "yyyyMMdd");

		// 创建 Calendar 对象
		Calendar now = Calendar.getInstance();
		if(endDateStr!=null && !endDateStr.equals("")){
			// 指定一个日期
			Date date = format.parse(endDateStr);
			// 对 calendar 设置为 date 所定的日期
			now.setTime(date);
		}

//		System.out.println(now.get(Calendar.DAY_OF_WEEK));

		if(now.get(Calendar.DAY_OF_WEEK)==41)
		{
			now.add(Calendar.DAY_OF_MONTH, -73);
		}else if(now.get(Calendar.DAY_OF_WEEK)==2 || now.get(Calendar.DAY_OF_WEEK)==3)
		{
			now.add(Calendar.DAY_OF_MONTH, -74);
		}else{
			now.add(Calendar.DAY_OF_MONTH, -72);
		}

		// for 10.1 holiday
//		now.add(Calendar.DAY_OF_MONTH, -67);

		String dateStr = format.format(now.getTime());
//		System.out.println(dateStr);
		return dateStr;
	}




	public double computeLowestClosePriceBefore1Day4kdj(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double hightPrivce = 0.0;
		int i=0;
		for (HistorytradeInfo result : stockList) {
			if(i==0) {
				i++;
				continue;
			}
			if(i==1)
			{
				hightPrivce = result.getClose();
			}
			if(i==days)
			{
				break;
			}
			if(hightPrivce>result.getClose())
			{
				hightPrivce = result.getClose();
			}
			i++;
		}

		return hightPrivce;
	}


	public double computeHighestClosePrice4kdj(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double hightPrivce = 0.0;
		int i=0;
		for (HistorytradeInfo result : stockList) {
			if(i==0)
			{
				hightPrivce = result.getClose();
			}
			if(i==days)
			{
				break;
			}
			if(hightPrivce<result.getClose())
			{
				hightPrivce = result.getClose();
			}
			i++;
		}

		return hightPrivce;
	}


	public HistorytradeInfo computeHighestHighVol4kdj4Obj(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double hightPrivce = 0.0;
		HistorytradeInfo historytradeInfo = null;
		int i=0;
		for (HistorytradeInfo result : stockList) {
			if(i==0)
			{
				hightPrivce = result.getVol();
				historytradeInfo = result;
			}
			if(i==days)
			{
				break;
			}
			if(hightPrivce<result.getVol())
			{
				hightPrivce = result.getVol();
				historytradeInfo = result;
			}
			i++;
		}

		return historytradeInfo;
	}


	public HistorytradeInfo computeHighestHighPriceClose4kdj4Obj(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double hightPrivce = 0.0;
		HistorytradeInfo historytradeInfo = null;
		int i=0;
		for (HistorytradeInfo result : stockList) {
			if(i==0)
			{
				hightPrivce = result.getClose();
				historytradeInfo = result;
			}
			if(i==days)
			{
				break;
			}
			if(hightPrivce<result.getClose())
			{
				hightPrivce = result.getClose();
				historytradeInfo = result;
			}
			i++;
		}

		return historytradeInfo;
	}


	public double computeHighestClosePriceBefore1Day4kdj(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double hightPrivce = 0.0;
		int i=0;
		for (HistorytradeInfo result : stockList) {
			if(i==0) {
				i++;
				continue;
			}
			if(i==1)
			{
				hightPrivce = result.getClose();
			}
			if(i==days)
			{
				break;
			}
			if(hightPrivce<result.getClose())
			{
				hightPrivce = result.getClose();
			}
			i++;
		}

		return hightPrivce;
	}


	public String getStartDateStr360DaysAfter(String endDateStr) throws ParseException
	{
		SimpleDateFormat format =  new SimpleDateFormat( "yyyyMMdd");
		// 创建 Calendar 对象
		Calendar now = Calendar.getInstance();
//	    if(endDateStr!=null && !endDateStr.equals("")){
		// 指定一个日期
		Date date = format.parse(endDateStr);
		// 对 calendar 设置为 date 所定的日期
		now.setTime(date);
//	    }


		int days = 360;
		now.add(Calendar.DAY_OF_MONTH, days);

		String dateStr = format.format(now.getTime());
		return dateStr;
	}

	public List<String> findDaysStr(String begintTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dBegin = null;
		Date dEnd = null;
		try {
			dBegin = sdf.parse(begintTime);
			dEnd = sdf.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<String> daysStrList = new ArrayList<String>();
		daysStrList.add(sdf.format(dBegin));
		Calendar calBegin = Calendar.getInstance();
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(dEnd);
		while (dEnd.after(calBegin.getTime())) {
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			String dayStr = sdf.format(calBegin.getTime());
			daysStrList.add(dayStr);
		}
		return daysStrList;
	}

	public String getStartDateStr60daysBefore(String endDateStr) throws ParseException
	{
		SimpleDateFormat format =  new SimpleDateFormat( "yyyyMMdd");

		// 创建 Calendar 对象
		Calendar now = Calendar.getInstance();
		if(endDateStr!=null && !endDateStr.equals("")){
			// 指定一个日期
			Date date = format.parse(endDateStr);
			// 对 calendar 设置为 date 所定的日期
			now.setTime(date);
		}
		if(now.get(Calendar.DAY_OF_WEEK)==41)
		{
			now.add(Calendar.DAY_OF_MONTH, -73);
		}else if(now.get(Calendar.DAY_OF_WEEK)==2 || now.get(Calendar.DAY_OF_WEEK)==3)
		{
			now.add(Calendar.DAY_OF_MONTH, -74);
		}else{
			now.add(Calendar.DAY_OF_MONTH, -72);
		}

		// for 10.1 holiday
//		now.add(Calendar.DAY_OF_MONTH, -67);
		String dateStr = format.format(now.getTime());
		return dateStr;
	}


	public String getStartDateStr15daysBefore(String endDateStr, int days) throws ParseException
	{
		SimpleDateFormat format =  new SimpleDateFormat( "yyyyMMdd");

		// 创建 Calendar 对象
		Calendar now = Calendar.getInstance();
		if(endDateStr!=null && !endDateStr.equals("")){
			// 指定一个日期
			Date date = format.parse(endDateStr);
			// 对 calendar 设置为 date 所定的日期
			now.setTime(date);
		}

		// for 10.1 holiday
		now.add(Calendar.DAY_OF_MONTH, days);

		String dateStr = format.format(now.getTime());
		return dateStr;
	}


	public String getStartDateStr360DaysBefore(String endDateStr) throws ParseException
	{
		SimpleDateFormat format =  new SimpleDateFormat( "yyyyMMdd");
		 // 创建 Calendar 对象  
	    Calendar now = Calendar.getInstance();  
//	    if(endDateStr!=null && !endDateStr.equals("")){
	    	// 指定一个日期  
	        Date date = format.parse(endDateStr);  
	        // 对 calendar 设置为 date 所定的日期  
	        now.setTime(date);  
//	    }
	    
	  
	    int days = -460;
	    now.add(Calendar.DAY_OF_MONTH, days);
	    

		String dateStr = format.format(now.getTime());
		return dateStr;
	}

	
	
	public double computeMA30_MA60(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double maSUM =0.0;
		int i=0;
		int k = 0;
		for (HistorytradeInfo result : stockList) {
			if(i==days)
			{
				break;
			}
				maSUM = maSUM+ result.getClose();
				i++;
				k++;
		}
		return maSUM/i;
	}




	public double computeVMA30_MA60(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double maSUM =0.0;
		int i=0;
		int k = 0;
		for (HistorytradeInfo result : stockList) {

			if(i==days)
			{
				break;
			}
			maSUM = maSUM+ result.getVol();
			i++;
			k++;
		}
		return maSUM/i;
	}
	

	public double computeLowestClosePrice4kdj(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double hightPrivce = 0.0;
		int i=0;
		for (HistorytradeInfo result : stockList) {
			if(i==0)
			{
				hightPrivce = result.getClose();
			}
			if(i==days)
			{
				break;
			}
			if(hightPrivce>result.getClose())
			{
				hightPrivce = result.getClose();
			}
			i++;
		}

		return hightPrivce;
	}

	public double computeHighestHighPrice4kdj(List<HistorytradeInfo> stockList, int days)throws Exception
	{
		double hightPrivce = 0.0;
		int i=0;
		for (HistorytradeInfo result : stockList) {
			if(i==0)
			{
				hightPrivce = result.getHigh();
			}
			if(i==days)
			{
				break;
			}
			if(hightPrivce<result.getHigh())
			{
				hightPrivce = result.getHigh();
			}
			i++;
		}

		return hightPrivce;
	}


	/**
	 * Calculate EMA,
	 *
	 * @param list
	 *            :Price list to calculate，the first at head, the last at tail.
	 * @return
	 */
	public   Double getEXPMA(final List<Double> list, final int number) {
		// 开始计算EMA值，
		Double k = 2.0 / (number + 1.0);// 计算出序数
		Double ema = list.get(0);// 第一天ema等于当天收盘价
		for (int i = 1; i < list.size(); i++) {
			// 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
			ema = list.get(i) * k + ema * (1 - k);
		}
		return ema;
	}

	/**
	 * calculate MACD values
	 *
	 * @param list
	 *            :Price list to calculate，the first at head, the last at tail.
	 * @param shortPeriod
	 *            :the short period value.
	 * @param longPeriod
	 *            :the long period value.
	 * @param midPeriod
	 *            :the mid period value.
	 * @return
	 */
	public   HashMap<String, Double> getMACD(final List<Double> list, final int shortPeriod, final int longPeriod, int midPeriod) {
		HashMap<String, Double> macdData = new HashMap<String, Double>();
		List<Double> diffList = new ArrayList<Double>();
		Double shortEMA = 0.0;
		Double longEMA = 0.0;
		Double dif = 0.0;
		Double dea = 0.0;

		for (int i = list.size() - 1; i >= 0; i--) {
			List<Double> sublist = list.subList(0, list.size() - i);
			shortEMA = this.getEXPMA(sublist, shortPeriod);
			longEMA = this.getEXPMA(sublist, longPeriod);
			dif = shortEMA - longEMA;
			diffList.add(dif);
		}
		dea = this.getEXPMA(diffList, midPeriod);
		macdData.put("DIF", dif);
		macdData.put("DEA", dea);
		macdData.put("MACD", (dif - dea) * 2);
		return macdData;
	}


	//均值
	public double getAverage(int num,List<Double> list ){
		double sum = 0;
		for(int i = 0;i < num;i++){
			sum += list.get(i);
		}
		return (double)(sum / num);
	}

	// big
	public List<StockCode> secondStrategy() throws Exception
	{
		List<StockCode> Results = new ArrayList();
		try {
			List<StockCode> queryResults = stockCodeRepository.findAllOrderReq();

			for (StockCode result : queryResults) {
				if(result.getMFRATIO2()!=null && result.getMFRATIO2().indexOf(".")>0
						&& result.getMCAP()!=null && result.getMCAP().indexOf(".")>0
						&& result.getPE()!=null && result.getPE().indexOf(".")>0){
					if(Double.parseDouble(result.getMFRATIO2())>0)
					{
						// 大于200亿
						if(Double.parseDouble(result.getMCAP())>1000000000.00)
						{
							Results.add(result);
						}
					}
				}else
				{
					continue;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally
		{}
		return Results;
	}



	public List<StockCode> firstStrategy() throws Exception
	{
		List<StockCode> Results = new ArrayList();
		List<StockCode> queryResults = null;
		queryResults = stockCodeRepository.findAllOrderReq();
		return queryResults;
	}


}

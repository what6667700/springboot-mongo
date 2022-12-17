package com.dc.dal;


import com.dc.model.Stock;

import java.util.Date;
import java.util.List;

public interface StockRepositoryDAL {

	public List<Stock> findAllOrderReq(String name, Date StartDate, Date endDate) throws Exception ;

//	public List<stock> findAllOrderReq(String name,Date StartDate) throws Exception ;

	public Stock findOneOrderReq(String name, String time) throws Exception ;
	public List<Stock> findAllOrderReqTimeDESC(String name, Date StartDate, Date endDate) throws Exception;
}

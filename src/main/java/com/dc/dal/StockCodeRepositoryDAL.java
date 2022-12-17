package com.dc.dal;

import com.dc.model.StockCode;

import java.util.List;

public interface StockCodeRepositoryDAL {

	public List<StockCode> findAllOrderReq();
	
	public List<StockCode> findOneOrderReq(String code) throws Exception ;
	
	public StockCode findOrderReqByName(String name) throws Exception ;
	
}

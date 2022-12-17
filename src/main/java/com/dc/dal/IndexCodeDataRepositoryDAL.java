package com.dc.dal;


import com.dc.model.IndexCodeData;
import com.dc.model.StockCode;

import java.util.List;

public interface IndexCodeDataRepositoryDAL {

	public List<StockCode> findAllOrderReq() throws Exception ;
	
	public List<StockCode> findOneOrderReq(String code) throws Exception ;
	
	public StockCode findOrderReqByName(String name) throws Exception ;

	public List<IndexCodeData> findIndexData(String code, String startDate, String endDate) throws Exception ;

	public void updateIndexDataMA120_MA240ById(IndexCodeData request)throws Exception;
	
}

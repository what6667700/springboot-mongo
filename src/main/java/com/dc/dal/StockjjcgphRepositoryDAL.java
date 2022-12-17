package com.dc.dal;


import com.dc.model.Stockjjcgph;

import java.util.List;

public interface StockjjcgphRepositoryDAL {

	 List<Stockjjcgph> findStockjjcgph() throws Exception ;
	
	 List<Stockjjcgph> findOneOrderReq(String code) throws Exception ;
	
	 Stockjjcgph findOrderReqByName(String name) throws Exception ;
	
}

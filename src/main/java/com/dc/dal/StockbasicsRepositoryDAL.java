package com.dc.dal;


import com.dc.model.Stockbasics;

import java.util.List;

public interface StockbasicsRepositoryDAL {


	List<Stockbasics> findstockByRevAndProfit(double rev, double profit) throws Exception;
	void updateCodeByName(String code, String name)throws Exception;

}

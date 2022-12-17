package com.dc.dal;


import com.dc.model.Profitability;

public interface ProfitabilityRepositoryDAL {


	public Profitability findOrderReqByName(String name) throws Exception;

}

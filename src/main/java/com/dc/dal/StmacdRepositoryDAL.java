package com.dc.dal;

import com.dc.model.Scpool;
import com.dc.model.Stkdj;
import com.dc.model.Stmacd;

import java.util.List;

public interface StmacdRepositoryDAL {

//	public List<scpool> findAllOrderReq() throws Exception ;
//	

    public List<Stkdj> findOrderReqByName(String name) throws Exception;

    public Stmacd findSTMACDByCodeAndDate(String code, String date) throws Exception;

    public List<Scpool> findAllScpool() throws Exception;

    public List<Scpool> findAllScpoolByEndDateStr(String endDateStr) throws Exception;

}

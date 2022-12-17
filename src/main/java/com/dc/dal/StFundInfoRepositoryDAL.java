package com.dc.dal;

import com.dc.model.StFundInfo;

import java.util.List;

public interface StFundInfoRepositoryDAL {
	
	public List<StFundInfo> findFundInfoByCode(String stockcode, String startDate, String endDate) throws Exception;
	
}

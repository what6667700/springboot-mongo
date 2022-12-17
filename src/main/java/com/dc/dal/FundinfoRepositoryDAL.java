package com.dc.dal;


import com.dc.model.Fundinfo;

import java.util.List;

public interface FundinfoRepositoryDAL {

	List<Fundinfo> findFundInfoByCode(String stockcode, String startDate, String endDate) throws Exception;
	
}

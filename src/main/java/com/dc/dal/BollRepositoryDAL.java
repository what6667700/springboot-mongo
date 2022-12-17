package com.dc.dal;


import com.dc.model.Scpool;
import com.dc.model.Boll;

import java.util.List;

public interface BollRepositoryDAL {


    List<Boll> findSTBollByCode(String code) throws Exception;

     List<Boll> findSTBollByCodeAndDate(String code, String date) throws Exception;

     List<Boll> findSTBollByCodeAndLteDate(String code, String date) throws Exception;

     List<Scpool> findAllScpool() throws Exception;

     List<Scpool> findAllScpoolByEndDateStr(String endDateStr) throws Exception;

}

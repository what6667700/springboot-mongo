package com.dc.dal;


import com.dc.model.DailyBasicPro;

import java.util.List;

public interface DailyBasicProRepositoryDAL {

    List<DailyBasicPro> findOrderReqByStockcodeAndDate(String stockcode, String startDate, String endDate) throws Exception;

}

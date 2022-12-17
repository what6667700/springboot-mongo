package com.dc.dal;


import com.dc.model.ScpoolVerify;

import java.util.List;

public interface ScpoolVerifyRepositoryDAL {


    List<ScpoolVerify> findOrderReqByName(String name) throws Exception;

    List<ScpoolVerify> findAllScpool() throws Exception;

}

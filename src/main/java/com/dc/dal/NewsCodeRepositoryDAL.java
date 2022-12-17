package com.dc.dal;


import com.dc.model.NewsCode;
import java.util.List;

public interface NewsCodeRepositoryDAL {

	public List<NewsCode> findAllOrderReq() throws Exception ;
}

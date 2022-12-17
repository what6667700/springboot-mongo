package com.dc.dal;

import com.dc.model.NewsCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsCodeRepositoryImpl implements NewsCodeRepositoryDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	private static Logger logger = LogManager.getLogger(NewsCodeRepositoryImpl.class);

	@Override
	public List<NewsCode> findAllOrderReq() throws Exception {

		List<NewsCode> queryResults = new ArrayList<>();
        try {
			Query query = new Query();
//			query.with(new Sort(new Order(Direction.DESC,"COUNT")));
			query.with(Sort.by(Sort.Order.desc("COUNT")));
			queryResults = mongoTemplate.find(query, NewsCode.class);
		 } catch (Exception e) {
             e.printStackTrace();
         }
		return queryResults;
	}
	

}

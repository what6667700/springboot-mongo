package com.dc.dal;


import com.dc.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class StockRepositoryImpl implements StockRepositoryDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	//@Loggable
	public List<Stock> findAllOrderReq(String name, Date StartDate, Date endDate) throws Exception {

		
				
		List<Stock> queryResults = new ArrayList<>();
        try {
			Query query = new Query();
			query.addCriteria(where("NAME").is(name));
			query.addCriteria(where("TIME").gte(StartDate).andOperator(where("TIME").lt(endDate)));
//			query.with(new Sort(new Order(Direction.ASC,"TIME")));
			query.with(Sort.by(Sort.Order.asc("TIME")));
			//query.addCriteria(where("TIME").gte(format.parse("2017-06-01")));
			queryResults = mongoTemplate.find(query, Stock.class);
		 } catch (Exception e) {
             e.printStackTrace();
         }
		return queryResults;
	}
	
	
	@Override
	//@Loggable
	public List<Stock> findAllOrderReqTimeDESC(String name,Date StartDate,Date endDate) throws Exception {

		List<Stock> queryResults = new ArrayList<>();
        try {
			Query query = new Query();
			query.addCriteria(where("NAME").is(name));
			query.addCriteria(where("TIME").gte(StartDate).andOperator(where("TIME").lt(endDate)));
//			query.with(new Sort(new Order(Direction.DESC,"TIME")));
			query.with(Sort.by(Sort.Order.desc("TIME")));
			//query.addCriteria(where("TIME").gte(format.parse("2017-06-01")));
			queryResults = mongoTemplate.find(query, Stock.class);
		 } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		return queryResults;
	}

	@Override
	public Stock findOneOrderReq(String name, String time) throws Exception {
		List<Stock> queryResults = new ArrayList<>();
		Stock s = null;
        try {
			Query query = new Query();
			query.addCriteria(where("NAME").is(name));
			query.addCriteria(where("TIME").is(time));
			//query.addCriteria(where("TIME").lte(format.parse("2017-06-29")));
			//query.addCriteria(where("TIME").gte(format.parse("2017-06-01")));
			queryResults = mongoTemplate.find(query, Stock.class);
			for (Stock result : queryResults) {
				s = result;
				break;
			}

		 } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		return s;
	}

	

}

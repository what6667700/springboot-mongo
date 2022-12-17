package com.dc.dal;

import com.dc.model.StockCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockCodeRepositoryImpl implements StockCodeRepositoryDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	private static Logger logger = LogManager.getLogger(StockCodeRepositoryImpl.class);

	@Override
	// @Loggable
	public List<StockCode> findAllOrderReq() {

		List<StockCode> queryResults = new ArrayList<>();
        try {
			Query query = new Query();
			queryResults = mongoTemplate.find(query, StockCode.class);
		 } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		return queryResults;
	}

	@Override
	public StockCode findOrderReqByName(String name) throws Exception {
		List<StockCode> queryResults = new ArrayList<>();

		StockCode stockCode = null;
		
        try {
			Query query = new Query();
			
			//query.addCriteria(Criteria.where("PERCENT").gte(3).andOperator(Criteria.where("PERCENT").lte(10)));
			
			query.addCriteria(Criteria.where("NAME").is(name));

//			query.with(new Sort(new Order(Direction.DESC,"PROFIT")));
			query.with(Sort.by(Sort.Order.desc("PROFIT")));
			
			queryResults = mongoTemplate.find(query, StockCode.class);
			
			if(queryResults!=null && queryResults.size()>0)
			{
				stockCode = queryResults.get(0);
			}
			
		 } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		return stockCode;
	}

	@Override
	public List<StockCode> findOneOrderReq(String code) throws Exception {
		List<StockCode> queryResults = new ArrayList<>();
        try {
			Query query = new Query();
			query.addCriteria(Criteria.where("SYMBOL").is(code));
			queryResults = mongoTemplate.find(query, StockCode.class);
		 } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		return queryResults;
	}
	

}

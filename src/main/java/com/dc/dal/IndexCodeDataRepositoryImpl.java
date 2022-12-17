package com.dc.dal;


import com.dc.model.IndexCodeData;
import com.dc.model.StockCode;
import com.dc.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class IndexCodeDataRepositoryImpl implements IndexCodeDataRepositoryDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	DateUtils dateUtils;

	@Override
	public List<StockCode> findAllOrderReq() throws Exception {

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
			query.addCriteria(Criteria.where("NAME").is(name));
//			query.with(new Sort(new Order(Direction.DESC,"PROFIT")));
			query.with(Sort.by(Sort.Order.desc("PROFIT")));
			queryResults = mongoTemplate.find(query, StockCode.class);
			
			if(queryResults!=null && queryResults.size()>0)
			{
				stockCode = queryResults.get(0);
			}
			
		 } catch (Exception e) {
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
             e.printStackTrace();
         }
		return queryResults;
	}

	@Override
	public List<IndexCodeData> findIndexData(String code, String startDate, String endDate)
			throws Exception {
		List<IndexCodeData> queryResults = new ArrayList<>();
		try {
			Query query = new Query();
			query.addCriteria(where("CODE").is(code));
			query.addCriteria(where("TIME").gte(dateUtils.dateToISODate(startDate)).andOperator(where("TIME").lte(dateUtils.dateToISODate(endDate))));
//			query.with(new Sort(new Order(Direction.DESC,"TIME")));
			query.with(Sort.by(Sort.Order.desc("TIME")));
			queryResults = mongoTemplate.find(query, IndexCodeData.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryResults;
	}

	@Override
	public void updateIndexDataMA120_MA240ById(IndexCodeData request)throws Exception{
		try {
			Query query = new Query(where("_id").is(request.getId()));
			Update update = new Update();
			update.set("ma120", request.getMa120());
			update.set("ma250", request.getMa250());
			update.set("ma30", request.getMa30());
			update.set("ma60", request.getMa60());
			update.set("ma5",request.getMa5());
			update.set("ma10",request.getMa10());
			update.set("ma20",request.getMa20());

			mongoTemplate.updateFirst(query, update, IndexCodeData.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}

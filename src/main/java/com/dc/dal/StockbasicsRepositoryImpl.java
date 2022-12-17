package com.dc.dal;


import com.dc.model.Stockbasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class StockbasicsRepositoryImpl implements StockbasicsRepositoryDAL {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void updateCodeByName(String code,String name)throws Exception
	{
		try {

			Query query = new Query(where("name").is(name));
			Update update = new Update();
			update.set("code", code);

			mongoTemplate.updateFirst(query, update, Stockbasics.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Stockbasics> findstockByRevAndProfit(double rev, double profit){
		// TODO Auto-generated method stub
		List<Stockbasics> queryResults = new ArrayList<>();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("rev").gte(rev));
			query.addCriteria(Criteria.where("profit").gte(profit));
//			query.with(new Sort(new Order(Direction.DESC,"profit")));
			query.with(Sort.by(Sort.Order.desc("profit")));
			queryResults = mongoTemplate.find(query, Stockbasics.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryResults;
	}

}

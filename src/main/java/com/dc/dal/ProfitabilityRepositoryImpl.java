package com.dc.dal;

import com.dc.dal.ProfitabilityRepositoryDAL;
import com.dc.model.Profitability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfitabilityRepositoryImpl implements ProfitabilityRepositoryDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	//	private static Logger logger = LogManager.getLogger(profitabilityRepositoryImpl.class);
	@Override
	public Profitability findOrderReqByName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Profitability> queryResults = new ArrayList<>();
		Profitability profitability = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(name));
			queryResults = mongoTemplate.find(query, Profitability.class);

			if (queryResults != null && queryResults.size() > 0) {
				profitability = queryResults.get(0);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return profitability;
	}

}
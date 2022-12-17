package com.dc.dal;

import com.dc.model.StFundInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class StFundInfoRepositoryImpl implements StFundInfoRepositoryDAL {
    @Autowired
    private MongoTemplate mongoTemplate;
    //
    private static Logger logger = LogManager.getLogger(StFundInfoRepositoryImpl.class);

    @Override
    public List<StFundInfo> findFundInfoByCode(String stockcode, String startDate, String endDate) throws Exception {
        // TODO Auto-generated method stub
        List<StFundInfo> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("stockcode").is(stockcode));
            query.addCriteria(where("opendate").gte(startDate).andOperator(where("opendate").lte(endDate)));
//			query.with(new Sort(new Order(Direction.DESC,"opendate")));
            query.with(Sort.by(Sort.Order.desc("opendate")));
            queryResults = mongoTemplate.find(query, StFundInfo.class);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return queryResults;
    }

}

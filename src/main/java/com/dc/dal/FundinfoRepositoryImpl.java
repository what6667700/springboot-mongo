package com.dc.dal;


import com.dc.model.Fundinfo;
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

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class FundinfoRepositoryImpl implements FundinfoRepositoryDAL {
    @Autowired
    private MongoTemplate mongoTemplate;
    private static Logger logger = LogManager.getLogger(FundinfoRepositoryImpl.class);

    @Override
    public List<Fundinfo> findFundInfoByCode(String stockcode, String startDate, String endDate) throws Exception {
        List<Fundinfo> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("code").is(stockcode));
            query.addCriteria(where("date").gte(startDate).andOperator(where("date").lte(endDate)));
            query.with(Sort.by(Sort.Order.desc("date")));
            queryResults = mongoTemplate.find(query, Fundinfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

}

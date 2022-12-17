package com.dc.dal;


import com.dc.model.Scpool;
import com.dc.model.Boll;
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
public class BollRepositoryImpl implements BollRepositoryDAL {
    @Autowired
    private MongoTemplate mongoTemplate;
    //
    private static Logger logger = LogManager.getLogger(BollRepositoryImpl.class);

    public List<Boll> findSTBollByCode(String code) throws Exception {
        List<Boll> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("code").is(code));
            query.with(Sort.by(Sort.Order.desc("date")));
            queryResults = mongoTemplate.find(query, Boll.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public List<Scpool> findAllScpool() throws Exception {
        List<Scpool> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            queryResults = mongoTemplate.find(query, Scpool.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }


    @Override
    public List<Scpool> findAllScpoolByEndDateStr(String endDateStr) throws Exception {
        List<Scpool> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(where("date").is(endDateStr));
            queryResults = mongoTemplate.find(query, Scpool.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public List<Boll> findSTBollByCodeAndDate(String code, String date) throws Exception {
        List<Boll> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("code").is(code));
            query.addCriteria(Criteria.where("date").is(date));
//				query.with(new Sort(new Order(Direction.ASC,"date")));
            query.with(Sort.by(Sort.Order.asc("date")));
            queryResults = mongoTemplate.find(query, Boll.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public List<Boll> findSTBollByCodeAndLteDate(String code, String date) throws Exception {
        List<Boll> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("code").is(code));
            query.addCriteria(Criteria.where("date").lte(date));
//				query.with(new Sort(new Order(Direction.DESC,"date")));
            query.with(Sort.by(Sort.Order.desc("date")));
            queryResults = mongoTemplate.find(query, Boll.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }


}

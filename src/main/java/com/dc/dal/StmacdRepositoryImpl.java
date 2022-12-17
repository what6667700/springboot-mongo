package com.dc.dal;


import com.dc.model.Scpool;
import com.dc.model.Stkdj;
import com.dc.model.Stmacd;
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
public class StmacdRepositoryImpl implements StmacdRepositoryDAL {
    @Autowired
    private MongoTemplate mongoTemplate;
    //
    private static Logger logger = LogManager.getLogger(StmacdRepositoryImpl.class);

    @Override
    public List<Stkdj> findOrderReqByName(String name) throws Exception {
        List<Stkdj> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("NAME").is(name));
            queryResults = mongoTemplate.find(query, Stkdj.class);
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
        List<Scpool> queryResults = null;
        try {
            Query query = new Query();
            query.addCriteria(where("createTime").is(endDateStr));
            queryResults = mongoTemplate.find(query, Scpool.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public Stmacd findSTMACDByCodeAndDate(String code, String date) throws Exception {
        Stmacd stmacd = null;
        try {
            Query query = new Query();

            query.addCriteria(where("stockcode").is(code));
            query.addCriteria(where("datep").is(date));
//        	query.with(new Sort(new Order(Direction.DESC,"datep")));
            query.with(Sort.by(Sort.Order.desc("datep")));
            List<Stmacd> queryResults = mongoTemplate.find(query, Stmacd.class);
            if (queryResults != null && queryResults.size() > 0) {
                for (Stmacd result : queryResults) {
                    stmacd = result;
                    break;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmacd;
    }


}

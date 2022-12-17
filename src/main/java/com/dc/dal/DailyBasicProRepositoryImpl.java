package com.dc.dal;


import com.dc.model.DailyBasicPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class DailyBasicProRepositoryImpl implements DailyBasicProRepositoryDAL {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<DailyBasicPro> findOrderReqByStockcodeAndDate(String stockcode, String startDate, String endDate) throws Exception {
        List<DailyBasicPro> queryResults = null;
        try {
            Query query = new Query();

            query.addCriteria(where("ts_code").is(stockcode));
            query.addCriteria(where("trade_date").lte(endDate).andOperator(where("trade_date").gte(startDate)));
            query.with(Sort.by(Sort.Order.desc("trade_date")));
            queryResults = mongoTemplate.find(query, DailyBasicPro.class);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return queryResults;
    }
}

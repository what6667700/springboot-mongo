package com.dc.dal;


import com.dc.model.Stockjjcgph;
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

@Component
public class StockjjcgphRepositoryImpl implements StockjjcgphRepositoryDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static Logger logger = LogManager.getLogger(StockjjcgphRepositoryImpl.class);

    @Override
    // @Loggable
    public List<Stockjjcgph> findStockjjcgph() throws Exception {

        List<Stockjjcgph> queryResults = new ArrayList<>();
        try {
            Query query = new Query();

            query.addCriteria(Criteria.where("REPORTDATE").is("2020-12-31"));
            query.addCriteria(Criteria.where("SHULIANG").gte(6));

            queryResults = mongoTemplate.find(query, Stockjjcgph.class);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public Stockjjcgph findOrderReqByName(String name) throws Exception {
        List<Stockjjcgph> queryResults = new ArrayList<>();

        Stockjjcgph stockCode = null;

        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("NAME").is(name));

//			query.with(new Sort(new Order(Direction.DESC,"PROFIT")));
            query.with(Sort.by(Sort.Order.desc("PROFIT")));
            queryResults = mongoTemplate.find(query, Stockjjcgph.class);

            if (queryResults != null && queryResults.size() > 0) {
                stockCode = queryResults.get(0);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stockCode;
    }

    @Override
    public List<Stockjjcgph> findOneOrderReq(String code) throws Exception {
        List<Stockjjcgph> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("SYMBOL").is(code));
            queryResults = mongoTemplate.find(query, Stockjjcgph.class);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return queryResults;
    }


}

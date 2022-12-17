package com.dc.dal;


import com.dc.dal.MaketInfosRepositoryDAL;
import com.dc.model.HistorytradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class MaketInfosRepositoryImpl implements MaketInfosRepositoryDAL {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<HistorytradeInfo> findHistorytradeInfo(String code, String startDate, String endDate) throws Exception {
        List<HistorytradeInfo> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(where("code").is(code));
            query.addCriteria(where("date").gte(startDate).andOperator(where("date").lt(endDate)));
//			query.with(new Sort(new Order(Direction.ASC,"date")));
            query.with(Sort.by(Sort.Order.asc("date")));
            queryResults = mongoTemplate.find(query, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public List<HistorytradeInfo> findHistorytradeInfo2(String code, String startDate, String endDate) throws Exception {
        List<HistorytradeInfo> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(where("code").is(code));
            query.addCriteria(where("date").gt(startDate).andOperator(where("date").lt(endDate)));
//			query.with(new Sort(new Order(Direction.ASC,"date")));
            query.with(Sort.by(Sort.Order.asc("date")));
            queryResults = mongoTemplate.find(query, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public List<HistorytradeInfo> findHistorytradeInfo3(String code, String startDate, String endDate) throws Exception {
        List<HistorytradeInfo> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(where("code").is(code));
            query.addCriteria(where("date").gte(startDate).andOperator(where("date").lte(endDate)));
//			query.with(new Sort(new Order(Direction.ASC,"date")));
            query.with(Sort.by(Sort.Order.asc("date")));
            queryResults = mongoTemplate.find(query, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public List<HistorytradeInfo> findHistorytradeInfoByDesc(String code, String startDate, String endDate) throws Exception {
        List<HistorytradeInfo> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(where("code").is(code));
            query.addCriteria(where("date").gte(startDate).andOperator(where("date").lt(endDate)));
//			query.with(new Sort(new Order(Direction.DESC,"date")));
            query.with(Sort.by(Sort.Order.desc("date")));
            queryResults = mongoTemplate.find(query, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }


    @Override
    public List<HistorytradeInfo> findHistorytradeInfoByDesc4MA30_MA60(String code, String startDate, String endDate) throws Exception {
        List<HistorytradeInfo> queryResults = null;
        try {
            Query query = new Query();
            query.addCriteria(where("code").is(code));
            query.addCriteria(where("date").gte(startDate).andOperator(where("date").lte(endDate)));
//			query.with(new Sort(new Order(Direction.DESC,"date")));
            query.with(Sort.by(Sort.Order.asc("date")));
            queryResults = mongoTemplate.find(query, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }


    @Override
    public List<HistorytradeInfo> findHistorytradeInfo1day(String code, String startDate, String endDate)
            throws Exception {
        List<HistorytradeInfo> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(where("code").is(code));
            query.addCriteria(where("date").gte(startDate).andOperator(where("date").lte(endDate)));
//			query.with(new Sort(new Order(Direction.ASC,"date")));
            query.with(Sort.by(Sort.Order.asc("date")));
            //query.addCriteria(where("TIME").gte(format.parse("2017-06-01")));
            queryResults = mongoTemplate.find(query, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }


    @Override
    public void updateHistorytradeInfoById(HistorytradeInfo request) throws Exception {
        try {
            Query query = new Query(where("_id").is(request.getId()));
            Update update = new Update();
            update.set("ma30", request.getMa30());
            update.set("ma60", request.getMa60());
            mongoTemplate.updateFirst(query, update, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public void updateHistorytradeInfoMA120_MA240ById(HistorytradeInfo request) throws Exception {
        try {
            Query query = new Query(where("_id").is(request.getId()));
            Update update = new Update();
            update.set("ma120", request.getMa120());
            update.set("ma240", request.getMa240());
            update.set("ma30", request.getMa30());
            update.set("ma60", request.getMa60());
            mongoTemplate.updateFirst(query, update, HistorytradeInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}

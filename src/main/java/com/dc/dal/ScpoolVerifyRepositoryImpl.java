package com.dc.dal;


import com.dc.model.ScpoolVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScpoolVerifyRepositoryImpl implements ScpoolVerifyRepositoryDAL {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ScpoolVerify> findOrderReqByName(String name) throws Exception {
        List<ScpoolVerify> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("NAME").is(name));
            queryResults = mongoTemplate.find(query, ScpoolVerify.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }

    @Override
    public List<ScpoolVerify> findAllScpool() throws Exception {
        List<ScpoolVerify> queryResults = new ArrayList<>();
        try {
            Query query = new Query();
            queryResults = mongoTemplate.find(query, ScpoolVerify.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryResults;
    }


}

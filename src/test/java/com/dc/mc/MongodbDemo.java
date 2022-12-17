package com.dc.mc;


import com.dc.model.HistorytradeInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MongodbDemo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testAggregate(){
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.DESC, "trade_date");

        GroupOperation groupOperation = Aggregation.group("code");


        TypedAggregation<HistorytradeInfo> historytradeInfoTypedAggregation = Aggregation.newAggregation(HistorytradeInfo.class, sortOperation,groupOperation);
        AggregationResults<Map> aggregate = mongoTemplate.aggregate(historytradeInfoTypedAggregation, Map.class);
        List<Map> mappedResults = aggregate.getMappedResults();
        for (Map item:mappedResults) {
            System.out.println(item);
        }

    }

}

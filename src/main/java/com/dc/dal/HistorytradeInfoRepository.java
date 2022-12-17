package com.dc.dal;


import com.dc.dal.HistorytradeInfoRepositoryDAL;
import com.dc.model.HistorytradeInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistorytradeInfoRepository extends MongoRepository<HistorytradeInfo, String>, HistorytradeInfoRepositoryDAL {

}

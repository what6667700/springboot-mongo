package com.dc.dal;


import com.dc.model.StFundInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StFundInfoRepository extends MongoRepository<StFundInfo, String>, StFundInfoRepositoryDAL {

}

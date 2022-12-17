package com.dc.dal;


import com.dc.model.StockCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockCodeRepository extends MongoRepository<StockCode, String>, StockCodeRepositoryDAL {

}

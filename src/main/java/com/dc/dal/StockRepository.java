package com.dc.dal;


import com.dc.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String>, StockRepositoryDAL {

}

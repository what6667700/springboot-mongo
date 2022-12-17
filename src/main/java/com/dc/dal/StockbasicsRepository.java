package com.dc.dal;


import com.dc.model.Stockbasics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockbasicsRepository extends MongoRepository<Stockbasics, String>, StockbasicsRepositoryDAL {

}

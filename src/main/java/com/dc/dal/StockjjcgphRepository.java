package com.dc.dal;


import com.dc.model.Stockjjcgph;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockjjcgphRepository extends MongoRepository<Stockjjcgph, String>, StockjjcgphRepositoryDAL {

}

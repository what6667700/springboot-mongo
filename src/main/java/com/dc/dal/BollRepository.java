package com.dc.dal;


import com.dc.model.Boll;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BollRepository extends MongoRepository<Boll, String> {

}

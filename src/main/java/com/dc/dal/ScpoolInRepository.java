package com.dc.dal;


import com.dc.model.ScpoolIn;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScpoolInRepository extends MongoRepository<ScpoolIn, String>, ScpoolInRepositoryDAL {

}

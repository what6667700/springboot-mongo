package com.dc.dal;


import com.dc.model.Scpool;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScpoolRepository extends MongoRepository<Scpool, String>, ScpoolRepositoryDAL {

}

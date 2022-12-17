package com.dc.dal;


import com.dc.model.ScpoolVerify;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScpoolVerifyRepository extends MongoRepository<ScpoolVerify, String>, ScpoolVerifyRepositoryDAL {

}

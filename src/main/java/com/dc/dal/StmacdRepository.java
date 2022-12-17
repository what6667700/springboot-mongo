package com.dc.dal;


import com.dc.dal.StmacdRepositoryDAL;
import com.dc.model.Stmacd;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StmacdRepository extends MongoRepository<Stmacd, String>, StmacdRepositoryDAL {

}

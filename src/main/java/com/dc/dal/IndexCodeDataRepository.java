package com.dc.dal;

import com.dc.dal.IndexCodeDataRepositoryDAL;
import com.dc.model.IndexCodeData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IndexCodeDataRepository extends MongoRepository<IndexCodeData, String>, IndexCodeDataRepositoryDAL {

}

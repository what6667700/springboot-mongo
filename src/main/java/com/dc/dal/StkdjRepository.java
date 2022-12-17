package com.dc.dal;


import com.dc.dal.StkdjRepositoryDAL;
import com.dc.model.Stkdj;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StkdjRepository extends MongoRepository<Stkdj, String>, StkdjRepositoryDAL {

}

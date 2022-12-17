package com.dc.dal;


import com.dc.dal.MaketInfosRepositoryDAL;
import com.dc.model.MaketInfos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaketInfosRepository extends MongoRepository<MaketInfos, String>, MaketInfosRepositoryDAL {

}

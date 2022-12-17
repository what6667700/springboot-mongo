package com.dc.dal;


import com.dc.model.DailyBasicPro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DailyBasicProRepository  extends MongoRepository<DailyBasicPro, String>,DailyBasicProRepositoryDAL {
}

package com.dc.dal;

import com.dc.dal.ProfitabilityRepositoryDAL;
import com.dc.model.Profitability;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfitabilityRepository extends MongoRepository<Profitability, String>, ProfitabilityRepositoryDAL {

}

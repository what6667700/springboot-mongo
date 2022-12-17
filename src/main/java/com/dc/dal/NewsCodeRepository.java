package com.dc.dal;

import com.dc.dal.NewsCodeRepositoryDAL;
import com.dc.model.NewsCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsCodeRepository extends MongoRepository<NewsCode, String>, NewsCodeRepositoryDAL {

}

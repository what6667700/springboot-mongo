package com.dc.dal;


import com.dc.model.Fundinfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FundinfoRepository extends MongoRepository<Fundinfo,String> {

}

package com.dc.dal;

import org.springframework.data.domain.Sort;
import com.dc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import java.util.List;

@Repository
public class UserDALImpl implements UserDAL {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<User> findAll() {
        return template.findAll(User.class);
    }

    @Override
    public User findById(String userId) {
        return template.findById(userId,User.class);
    }

    @Override
    public User save(User user) {
        return template.save(user);
    }

    @Override
    public void deleteById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        template.remove(query, User.class);
    }
}

package com.dc.dal;

import com.dc.model.User;

import java.util.List;

public interface UserDAL {
    List<User> findAll();

    User findById(String userId);

    User save(User user);

    void deleteById(String userId);
}

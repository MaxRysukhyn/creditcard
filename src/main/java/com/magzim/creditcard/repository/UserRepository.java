package com.magzim.creditcard.repository;

import com.magzim.creditcard.model.User;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
public interface UserRepository {

    User save(User user);

    //false if not found
    boolean delete(int id);

    //null if not found
    User get(int id);

    //null if not found
    User getByEmail(String email);

    List<User> getAll();
}

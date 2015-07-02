package com.magzim.creditcard.service;

import com.magzim.creditcard.model.User;
import com.magzim.creditcard.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
public interface UserService {

    public User save(User user);

    public void delete(int id) throws NotFoundException;

    public User get(int id) throws NotFoundException;

    public User getByEmail(String email)  throws NotFoundException;

    public List<User> getAll();

    public void update(User user) throws NotFoundException;
}

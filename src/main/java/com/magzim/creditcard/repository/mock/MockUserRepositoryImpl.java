package com.magzim.creditcard.repository.mock;

import com.magzim.creditcard.LoggerWrapper;
import com.magzim.creditcard.model.User;
import com.magzim.creditcard.repository.UserRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by max on 7/4/15.
 */
public class MockUserRepositoryImpl implements UserRepository {

    public static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepositoryImpl.class);

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return true;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return null;
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("getByEmail" + email);
        return null;
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        return Collections.emptyList();
    }
}

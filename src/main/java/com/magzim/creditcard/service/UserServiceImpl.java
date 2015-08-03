package com.magzim.creditcard.service;

import com.magzim.creditcard.model.User;
import com.magzim.creditcard.repository.UserRepository;
import com.magzim.creditcard.util.exception.ExceptionUtil;
import com.magzim.creditcard.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    public User get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    public User getByEmail(String email) throws NotFoundException {
        return ExceptionUtil.check(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void update(User user) throws NotFoundException {
        ExceptionUtil.check(repository.save(user), user.getId());
    }
}

package com.magzim.creditcard.web.user;

import com.magzim.creditcard.LoggerWrapper;
import com.magzim.creditcard.model.User;
import com.magzim.creditcard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
@Controller
public class AdminUserRestController {

    private static final LoggerWrapper LOG = LoggerWrapper.get(AdminUserRestController.class);

    @Autowired
    private UserService service;

    public List<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        LOG.info("get" + id);
        return service.get(id);
    }

    public User create(User user) {
        LOG.info("create");
        return service.save(user);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user) {
        LOG.info("update " + user);
        service.update(user);
    }

    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }
}

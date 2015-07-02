package com.magzim.creditcard.web.user;

import com.magzim.creditcard.LoggedUser;
import com.magzim.creditcard.LoggerWrapper;
import com.magzim.creditcard.model.User;
import com.magzim.creditcard.service.UserService;

/**
 * Created by max on 6/27/15.
 */
public class UserRestController {

    private static final LoggerWrapper LOG = LoggerWrapper.get(UserRestController.class);

    private UserService service;

    public User get() {
        int id = LoggedUser.id();
        LOG.info("get", id);
        return service.get(id);
    }

    public void delete() {
        int id = LoggedUser.id();
        LOG.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user) {
        int id = LoggedUser.id();
        LOG.info("update");
        service.update(user);
    }
}

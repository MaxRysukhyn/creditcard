package com.magzim.creditcard.web.card;

import com.magzim.creditcard.LoggedUser;
import com.magzim.creditcard.LoggerWrapper;
import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
@Controller
public class UserCardRestController {

    private static final LoggerWrapper LOG = LoggerWrapper.get(UserCardRestController.class);

    @Autowired
    private UserCardService service;

    public UserCard get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get card {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void block(UserCard card) {
        int userId = LoggedUser.id();
        LOG.info("block card {} for user {}", card, userId);
        service.block(card, userId);
    }

    public void unblock(UserCard card) {
        int userId = LoggedUser.id();
        LOG.info("unblock card {} for user {}", card, userId);
        service.unblock(card, userId);
    }

    public UserCard update(UserCard card) {
        int userId = LoggedUser.id();
        LOG.info("update card {} of the user {}", card, userId);
        return service.update(card, userId);
    }

    public List<UserCard> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for user {}", userId);
        return service.getAll(userId);
    }
}

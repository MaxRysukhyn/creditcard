package com.magzim.creditcard.service;

import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
public interface UserCardService {

    void pay(UserCard card, int userId, int destinationCardId);

    void addFunds (UserCard card, int userId);

    UserCard save(UserCard card, int userId);

    void block(UserCard card, int userId) throws NotFoundException;;

    void unblock (UserCard card, int userId) throws NotFoundException;;

    UserCard update(UserCard card, int userId) throws NotFoundException;;

    UserCard get(int id, int userId) throws NotFoundException;;

    List<UserCard> getAll(int userId);

}

package com.magzim.creditcard.service;

import com.magzim.creditcard.model.UserCard;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
public interface UserCardService {

    UserCard save(UserCard userCard, int userId);

    boolean block(int id, int userId);

    boolean unblock (int id, int userId);

    UserCard update(UserCard userCard, int userId);

    UserCard get(int id, int userId);

    List<UserCard> getAll(int userId);

}

package com.magzim.creditcard.repository;

import com.magzim.creditcard.model.UserCard;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
public interface UserCardRepository {

    //UserCard.user = null
    UserCard save(UserCard card, int userId);

    //null if not found
    UserCard get(int id, int userId);

    List<UserCard> getAll(int userId);
}

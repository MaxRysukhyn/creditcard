package com.magzim.creditcard.repository;

import com.magzim.creditcard.model.UserCard;

import java.util.List;

/**
 * Created by max on 6/27/15.
 */
public interface UserCardRepository {

    UserCard pay(UserCard card, int userId, int destinationCardId);

    UserCard addFunds (UserCard card, int userId);

    //UserCard.user = null
    UserCard save(UserCard card, int userId);

    void block(UserCard card, int userId);

    void unblock (UserCard card, int userId);

    //null if not found
    UserCard get(int id, int userId);

    List<UserCard> getAll(int userId);
}

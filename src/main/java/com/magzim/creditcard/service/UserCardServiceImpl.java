package com.magzim.creditcard.service;

import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.repository.UserCardRepository;
import com.magzim.creditcard.util.exception.ExceptionUtil;

import java.util.List;

/**
 * Created by max on 7/1/15.
 */
public class UserCardServiceImpl implements UserCardService {

    private UserCardRepository repository;

    @Override
    public UserCard save(UserCard userCard, int userId) {
        return repository.save(userCard, userId);
    }

    @Override
    public void block(UserCard card, int userId) {
        ExceptionUtil.check(repository.save(card, userId), card.getId());
    }

    @Override
    public void unblock(UserCard card, int userId) {
        ExceptionUtil.check(repository.save(card, userId), card.getId());
    }

    @Override
    public UserCard update(UserCard userCard, int userId) {
        return ExceptionUtil.check(repository.save(userCard, userId), userCard.getId());
    }

    @Override
    public UserCard get(int id, int userId) {
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public List<UserCard> getAll(int userId) {
        return repository.getAll(userId);
    }
}

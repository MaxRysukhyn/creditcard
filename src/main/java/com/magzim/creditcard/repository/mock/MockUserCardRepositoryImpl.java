package com.magzim.creditcard.repository.mock;

import com.magzim.creditcard.LoggerWrapper;
import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.repository.UserCardRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Created by max on 7/7/15.
 */
@Repository
public class MockUserCardRepositoryImpl implements UserCardRepository{
    public static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepositoryImpl.class);

    @Override
    public UserCard save(UserCard card, int userId) {
        LOG.info("save card {} of user {}", card, userId);
        return null;
    }

    @Override
    public UserCard get(int id, int userId) {
        LOG.info("get card {} of user {}", id, userId);
        return null;
    }

    @Override
    public List<UserCard> getAll(int userId) {
        LOG.info("getAll cards of user {}", userId);
        return Collections.emptyList();
    }
}

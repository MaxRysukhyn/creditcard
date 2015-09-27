package com.magzim.creditcard.repository.datajpa;

import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.repository.UserCardRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by max on 9/23/15.
 */
@Repository
public class DataJpaUserCardRepositoryImpl implements UserCardRepository{
    @Override
    public UserCard save(UserCard card, int userId) {
        return null;
    }

    @Override
    public UserCard get(int id, int userId) {
        return null;
    }

    @Override
    public List<UserCard> getAll(int userId) {
        return null;
    }
}

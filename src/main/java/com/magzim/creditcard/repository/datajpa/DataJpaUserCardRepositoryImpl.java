package com.magzim.creditcard.repository.datajpa;

import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.repository.UserCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by max on 9/23/15.
 */
@Repository
public class DataJpaUserCardRepositoryImpl implements UserCardRepository{

    @Autowired
    private ProxyUserCardRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;

    @Override
    @Transactional
    public UserCard save(UserCard card, int userId) {
        card.setUser(userProxy.getOne(userId));
        if(!card.isNew() && get(card.getId(), userId) == null) {
            return null;
        } else {
            return proxy.save(card);
        }
    }

    @Override
    public UserCard get(int id, int userId) {
        return proxy.findOne(id, userId);
    }

    @Override
    public List<UserCard> getAll(int userId) {
        return proxy.findAll(userId);
    }
}

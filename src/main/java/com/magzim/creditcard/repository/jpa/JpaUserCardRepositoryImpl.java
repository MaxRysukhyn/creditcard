package com.magzim.creditcard.repository.jpa;

import com.magzim.creditcard.model.User;
import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.repository.UserCardRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by max on 8/23/15.
 */
@Repository
@Transactional(readOnly = true)
public class JpaUserCardRepositoryImpl implements UserCardRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserCard save(UserCard card, int userId) {
        User ref = em.getReference(User.class, userId);
        card.setUser(ref);

        if (card.isNew()) {
            em.persist(card);
        } else {
            if(get(card.getId(), userId) == null) return null;
            else em.merge(card);
        }

        return card;
    }

    @Override
    public UserCard get(int id, int userId) {
        return em.find(UserCard.class, id);
    }

    @Override
    public List<UserCard> getAll(int userId) {
        return em.createNamedQuery(UserCard.ALL_SORTED, UserCard.class).
                setParameter("userId", userId).
                getResultList();
    }
}

package com.magzim.creditcard.repository.datajpa;

import com.magzim.creditcard.model.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by max on 9/27/15.
 */
@Transactional(readOnly = true)
public interface ProxyUserCardRepository extends JpaRepository<UserCard, Integer> {

    @Override
    UserCard save(UserCard card);

    @Query("SELECT c FROM UserCard c WHERE c.id=:id AND c.user.id=:userId")
    UserCard findOne(@Param("id")int id, @Param("userId")int userId);

    @Query("SELECT c FROM UserCard c WHERE c.user.id=:userId")
    List<UserCard> findAll(@Param("userId")int userId);
}

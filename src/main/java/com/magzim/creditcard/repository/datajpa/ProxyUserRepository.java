package com.magzim.creditcard.repository.datajpa;

import com.magzim.creditcard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by max on 9/27/15.
 */
public interface ProxyUserRepository  extends JpaRepository<User, Integer> {

    @Override
    @Transactional
    User save(User user);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll();

    User getByEmail(String email);
}

package com.magzim.creditcard.repository.jdbc;

import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.repository.UserCardRepository;
import com.magzim.creditcard.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by max on 7/19/15.
 */
@Repository
public class JdbcUserCardRepository implements UserCardRepository{

    public static final BeanPropertyRowMapper<UserCard> ROW_MAPPER = BeanPropertyRowMapper.newInstance(UserCard.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertCard;

    @Autowired
    public JdbcUserCardRepository(DataSource dataSource) {
        this.insertCard = new SimpleJdbcInsert(dataSource).
                withTableName("CARDS").
                usingGeneratedKeyColumns("id");
    }

    @Override
    public UserCard save(UserCard card, int userId) {
        SqlParameterSource map = new MapSqlParameterSource().
                addValue("id", card.getId()).
                addValue("amount", card.getAmount()).
                addValue("password", card.getPassword()).
                addValue("lastUsed", card.getLastUsed()).
                addValue("blocked", card.isBlocked()).
                addValue("user_id", userId);

        if (card.isNew()) {
            Number newKey = insertCard.executeAndReturnKey(map);
            card.setId(newKey.intValue());
        } else {
            if (namedParameterJdbcTemplate.update(
                    "UPDATE cards SET amount=:amount, password=:password, lastUsed=:lastUsed, " +
                            "blocked=:blocked WHERE id=:id AND user_id=:user_id", map) == 0);
            return null;
        }
        return card;
    }

    @Override
    public UserCard get(int id, int userId) {
        List<UserCard> userCards = jdbcTemplate.query(
                "SELECT * FROM cards WHERE id = ? AND user_id = ?", ROW_MAPPER, id, userId);
        return CollectionUtils.isEmpty(userCards) ? null : DataAccessUtils.requiredSingleResult(userCards);
    }

    @Override
    public UserCard getById(int id) {
        List<UserCard> userCards = jdbcTemplate.query(
          "SELECT * FROM cards WHERE id = ?", ROW_MAPPER, id);
        return CollectionUtils.isEmpty(userCards) ? null : DataAccessUtils.requiredSingleResult(userCards);
    }

    @Override
    public List<UserCard> getAll(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM cards WHERE user_id=? ORDER BY id", ROW_MAPPER, userId);
    }
}

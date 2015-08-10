package com.magzim.creditcard.service;

import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.util.DbPopulator;
import com.magzim.creditcard.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static com.magzim.creditcard.CardTestData.*;
import static com.magzim.creditcard.model.BaseEntity.START_SEQ;

/**
 * Created by max on 7/22/15.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

@RunWith(SpringJUnit4ClassRunner.class)
@Sql("classpath:db/populateDB.sql")
public class UserCardServiceTest {

    @Autowired
    protected UserCardService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testGet() {
        UserCard testCard =  service.get(CARD1_ID, START_SEQ);
        MATCHER.assertEquals(CARD1, testCard);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() {
        service.get(1, START_SEQ);
    }

    @Test
    public void testSave() {
        UserCard testCard = getCreated();
        service.save(testCard, START_SEQ);
        MATCHER.assertListEquals(Arrays.asList(CARD1, CARD2, testCard), service.getAll(START_SEQ));
    }

    @Test
    public void testGetAll() {
        MATCHER.assertListEquals(Arrays.asList(CARD1, CARD2), service.getAll(START_SEQ));
    }
}

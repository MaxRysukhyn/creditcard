package com.magzim.creditcard.service;

import com.magzim.creditcard.model.UserCard;
import com.magzim.creditcard.util.DbPopulator;
import com.magzim.creditcard.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
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
@ActiveProfiles("postgres")
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
        TestCard tc = new TestCard(100.00, "pass", LocalDateTime.of(2015, 1, 8, 18, 0), false);
        UserCard createdCard = service.save(tc.asCard(), START_SEQ);
        tc.setId(createdCard.getId());
        MATCHER.assertListEquals(Arrays.asList(tc, CARD2, CARD1), service.getAll(START_SEQ));
    }

    @Test
    public void testGetAll() { MATCHER.assertListEquals(Arrays.asList(CARD2, CARD1), service.getAll(START_SEQ));
    }
}

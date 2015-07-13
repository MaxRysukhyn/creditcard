package com.magzim.creditcard.web.mock;

import com.magzim.creditcard.model.Role;
import com.magzim.creditcard.model.User;
import com.magzim.creditcard.util.exception.NotFoundException;
import com.magzim.creditcard.web.user.AdminUserRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by max on 7/13/15.
 */
@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminSpringMockTest {

    @Autowired
    private AdminUserRestController controller;

    @Test
    public void testCreate() throws Exception {
        controller.create(new User(null, "name", "mail@gmail.com", "password", true, Role.ROLE_USER));
    }

    @Test
    public void testDelete() {
        controller.delete(7);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() {
        controller.delete(0);
    }
}

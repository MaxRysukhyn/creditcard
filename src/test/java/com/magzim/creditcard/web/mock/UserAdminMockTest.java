package com.magzim.creditcard.web.mock;

import com.magzim.creditcard.model.Role;
import com.magzim.creditcard.model.User;
import com.magzim.creditcard.util.exception.NotFoundException;
import com.magzim.creditcard.web.user.AdminUserRestController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by max on 7/12/15.
 */
public class UserAdminMockTest {
    private static ConfigurableApplicationContext appCtx;
    private static AdminUserRestController controller;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminUserRestController.class);
    }

    @AfterClass
    public static void afterClass() {
        appCtx.close();
    }

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

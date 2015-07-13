package com.magzim.creditcard.web.mock;

import com.magzim.creditcard.web.card.UserCardRestController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by max on 7/13/15.
 */
public class UserCardMockTest {
    private static ConfigurableApplicationContext ctx;
    private static UserCardRestController controller;

    @BeforeClass
    public static void beforeClass() {
        ctx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(ctx.getBeanDefinitionNames()) + "\n");
        controller = ctx.getBean(UserCardRestController.class);
    }

    @AfterClass
    public static void afterClass() {
        ctx.close();
    }
}

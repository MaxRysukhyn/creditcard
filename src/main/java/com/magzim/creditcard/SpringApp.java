package com.magzim.creditcard;

import com.magzim.creditcard.repository.jdbc.JdbcUserRepositoryImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by max on 7/20/15.
 */
public class SpringApp {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
            DataSource dataSource = appCtx.getBean(DataSource.class);
            JdbcUserRepositoryImpl userRepository = appCtx.getBean(JdbcUserRepositoryImpl.class);
            System.out.println(userRepository.getAll());
        }
    }
}

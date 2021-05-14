package orderplanning.adapter.persistence.config;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class PostgresTestContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + PostgresTestContainer.DB_URL,
                "spring.datasource.username=" + PostgresTestContainer.DB_USERNAME,
                "spring.datasource.password=" + PostgresTestContainer.DB_PASSWORD,
                "spring.flyway.url=" + PostgresTestContainer.DB_URL,
                "spring.flyway.user=" + PostgresTestContainer.DB_USERNAME,
                "spring.flyway.password=" + PostgresTestContainer.DB_PASSWORD
        ).applyTo(configurableApplicationContext.getEnvironment());
    }

}


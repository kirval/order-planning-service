package orderplanning.adapter.persistence.config;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresTestContainer extends PostgreSQLContainer<PostgresTestContainer> {

    public static String DB_URL;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;

    private static final String IMAGE_VERSION = "postgres:13-alpine";
    private static PostgresTestContainer container;

    private PostgresTestContainer() {
        super(IMAGE_VERSION);
    }

    public static PostgresTestContainer getInstance() {
        if (container == null) {
            container = new PostgresTestContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        DB_URL = container.getJdbcUrl();
        DB_USERNAME = container.getUsername();
        DB_PASSWORD = container.getPassword();
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }

}

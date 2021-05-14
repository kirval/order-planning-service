package orderplanning.adapter.persistence;

import orderplanning.adapter.persistence.config.PostgresTestContainer;
import orderplanning.adapter.persistence.config.PostgresTestContainerInitializer;
import orderplanning.domain.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {PostgresTestContainerInitializer.class})
@Transactional
class WarehousePersistenceAdapterTest {

    @Container
    private static final PostgreSQLContainer<PostgresTestContainer> POSTGRES_CONTAINER = PostgresTestContainer.getInstance();

    @Autowired
    private WarehousePersistenceAdapter warehousePersistenceAdapter;

    @Test
    @Sql("WarehousePersistenceAdapterTest.sql")
    void testFindWarehousesContainingProduct() {
        List<Warehouse> warehouses = warehousePersistenceAdapter.findWarehousesContainingProduct(1L);

        assertThat(warehouses).hasSize(1);
        assertThat(warehouses.get(0).getId()).isEqualTo(1L);
    }

}
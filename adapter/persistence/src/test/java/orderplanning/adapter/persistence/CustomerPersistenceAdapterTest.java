package orderplanning.adapter.persistence;

import orderplanning.adapter.persistence.config.PostgresTestContainer;
import orderplanning.adapter.persistence.config.PostgresTestContainerInitializer;
import orderplanning.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {PostgresTestContainerInitializer.class})
@Transactional
@Sql("CustomerPersistenceAdapterTest.sql")
class CustomerPersistenceAdapterTest {

    @Container
    private static final PostgreSQLContainer<PostgresTestContainer> POSTGRES_CONTAINER = PostgresTestContainer.getInstance();

    @Autowired
    private CustomerPersistenceAdapter customerPersistenceAdapter;

    @Test
    void testPersistCustomer() {
        Customer customerToSave = new Customer()
                .setName("Customer")
                .setCoordinateX(10)
                .setCoordinateY(10);
        Customer savedCustomer = customerPersistenceAdapter.persistCustomer(customerToSave);

        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(savedCustomer.getName()).isEqualTo("Customer");
        assertThat(savedCustomer.getCoordinateX()).isEqualTo(10);
        assertThat(savedCustomer.getCoordinateY()).isEqualTo(10);
    }

    @Test
    void testFindById() {
        Customer actualCustomer = customerPersistenceAdapter.findById(1L);

        assertThrows(IllegalArgumentException.class, () -> customerPersistenceAdapter.findById(2L));
        assertThat(actualCustomer.getId()).isEqualTo(1L);
    }

}
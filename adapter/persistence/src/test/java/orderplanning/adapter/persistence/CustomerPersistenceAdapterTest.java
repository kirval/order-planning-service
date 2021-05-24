package orderplanning.adapter.persistence;

import orderplanning.common.exception.QueryException;
import orderplanning.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@Sql("CustomerPersistenceAdapterTest.sql")
class CustomerPersistenceAdapterTest {

    @Autowired
    private CustomerPersistenceAdapter customerPersistenceAdapter;

    @Test
    void testPersistCustomer() {
        Customer customerToSave = new Customer()
                .setName("Customer")
                .setCoordinateX(10)
                .setCoordinateY(10);
        Customer savedCustomer = null;
        try {
            savedCustomer = customerPersistenceAdapter.persistCustomer(customerToSave);
        } catch (orderplanning.common.exception.PersistenceException e) {
            e.printStackTrace();
        }

        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(savedCustomer.getName()).isEqualTo("Customer");
        assertThat(savedCustomer.getCoordinateX()).isEqualTo(10);
        assertThat(savedCustomer.getCoordinateY()).isEqualTo(10);
    }

    @Test
    void testFindById() {
        Customer actualCustomer = null;
        try {
            actualCustomer = customerPersistenceAdapter.findById(1L);
        } catch (orderplanning.common.exception.QueryException e) {
            e.printStackTrace();
        }

        assertThrows(QueryException.class, () -> customerPersistenceAdapter.findById(2L));
        assertThat(actualCustomer.getId()).isEqualTo(1L);
    }

}
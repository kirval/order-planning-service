package orderplanning.adapter.persistence;

import orderplanning.domain.Order;
import orderplanning.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OrderPersistenceAdapterTest {

    @Autowired
    private OrderPersistenceAdapter orderPersistenceAdapter;

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Test
    @Sql("OrderPersistenceAdapterTest.sql")
    void testPersistOrder() {
        Long customerId = 1L;
        Long warehouseId = 1L;
        Long productId = 1L;
        Order orderToSave = new Order()
                .setProduct(new Product().setId(productId));
        Order savedOrder = orderPersistenceAdapter.persistOrder(orderToSave, customerId, warehouseId);

        assertThat(savedOrder.getId()).isNotNull();
        OrderJpaEntity orderJpa = orderJpaRepository.findById(savedOrder.getId()).get();
        assertThat(orderJpa.getCustomer().getId()).isEqualTo(customerId);
        assertThat(orderJpa.getWarehouse().getId()).isEqualTo(warehouseId);
        assertThat(orderJpa.getProduct().getId()).isEqualTo(productId);
    }

}
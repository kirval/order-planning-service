package orderplanning.adapter.persistence;

import orderplanning.domain.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class WarehousePersistenceAdapterTest {

    @Autowired
    private WarehousePersistenceAdapter warehousePersistenceAdapter;

    @Test
    @Sql("WarehousePersistenceAdapterTest.sql")
    void testFindWarehousesContainingProduct() {
        List<Warehouse> warehouses = null;
        try {
            warehouses = warehousePersistenceAdapter.findWarehousesContainingProduct(1L);
        } catch (orderplanning.common.exception.QueryException e) {
            e.printStackTrace();
        }

        assertThat(warehouses).hasSize(1);
        assertThat(warehouses.get(0).getId()).isEqualTo(1L);
    }

}
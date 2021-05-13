package orderplanning.application.port.out;

import orderplanning.domain.Warehouse;

import java.util.List;

public interface WarehouseQueryPort {

    List<Warehouse> findWarehousesContainingProduct(Long productId);

}

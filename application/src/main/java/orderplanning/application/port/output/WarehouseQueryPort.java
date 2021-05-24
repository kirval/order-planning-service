package orderplanning.application.port.output;

import orderplanning.common.exception.QueryException;
import orderplanning.domain.Warehouse;

import java.util.List;

public interface WarehouseQueryPort {

    List<Warehouse> findWarehousesContainingProduct(Long productId) throws QueryException;

}

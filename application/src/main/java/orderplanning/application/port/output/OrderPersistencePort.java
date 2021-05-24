package orderplanning.application.port.output;

import orderplanning.common.exception.PersistenceException;
import orderplanning.domain.Order;

public interface OrderPersistencePort {

    Order persistOrder(Order order, Long customerId, Long warehouseId) throws PersistenceException;

}

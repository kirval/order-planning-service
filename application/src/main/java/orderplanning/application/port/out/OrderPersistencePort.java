package orderplanning.application.port.out;

import orderplanning.domain.Order;

public interface OrderPersistencePort {

    Order persistOrder(Order order, Long customerId, Long warehouseId);

}

package orderplanning.adapter.persistence;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.output.OrderPersistencePort;
import orderplanning.common.PersistenceAdapter;
import orderplanning.common.exception.PersistenceException;
import orderplanning.domain.Order;

@PersistenceAdapter
@RequiredArgsConstructor
class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderJpaRepository repository;
    private final OrderJpaMapper mapper;

    @Override
    public Order persistOrder(Order order, Long customerId, Long warehouseId) throws PersistenceException {
        try {
            return mapper.jpaEntityToDomainEntity(
                    repository.save(mapper.domainEntityToJpaEntity(order, customerId, warehouseId))
            );
        } catch (Exception e) {
            throw new PersistenceException("Failed to save Order. " + e.getMessage());
        }
    }
}

package orderplanning.adapter.persistence;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.out.OrderPersistencePort;
import orderplanning.domain.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderJpaRepository repository;
    private final OrderJpaMapper mapper;

    @Override
    public Order persistOrder(Order order, Long customerId, Long warehouseId) {
        return mapper.jpaEntityToDomainEntity(
                repository.save(mapper.domainEntityToJpaEntity(order, customerId, warehouseId))
        );
    }
}

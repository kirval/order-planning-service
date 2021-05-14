package orderplanning.adapter.persistence;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.out.WarehouseQueryPort;
import orderplanning.domain.Warehouse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class WarehousePersistenceAdapter implements WarehouseQueryPort {

    private final WarehouseJpaRepository repository;
    private final WarehouseJpaMapper mapper;

    @Override
    public List<Warehouse> findWarehousesContainingProduct(Long productId) {
        return mapper.jpaEntityToDomainEntityPlain(
                repository.findAll(WarehouseJpaSpecifications.findByContainingProduct(productId))
        );
    }

}

package orderplanning.adapter.persistence;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.output.WarehouseQueryPort;
import orderplanning.common.PersistenceAdapter;
import orderplanning.common.exception.QueryException;
import orderplanning.domain.Warehouse;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
class WarehousePersistenceAdapter implements WarehouseQueryPort {

    private final WarehouseJpaRepository repository;
    private final WarehouseJpaMapper mapper;

    @Override
    public List<Warehouse> findWarehousesContainingProduct(Long productId) throws QueryException {
        try {
            return mapper.jpaEntityToDomainEntityPlain(
                    repository.findAll(WarehouseJpaSpecifications.findByContainingProduct(productId))
            );
        } catch (Exception e) {
            throw new QueryException(
                    String.format("Failed find Warehouses with Product id = {%s} " + e.getMessage(), productId));
        }
    }

}

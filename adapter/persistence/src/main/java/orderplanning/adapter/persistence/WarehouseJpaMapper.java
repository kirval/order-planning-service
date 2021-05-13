package orderplanning.adapter.persistence;

import orderplanning.domain.Warehouse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
interface WarehouseJpaMapper {

    String WAREHOUSE_JPA_ENTITY_TO_DOMAIN_ENTITY_PLAIN = "WAREHOUSE_JPA_ENTITY_TO_DOMAIN_ENTITY";

    @Named(WAREHOUSE_JPA_ENTITY_TO_DOMAIN_ENTITY_PLAIN)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "orders", ignore = true)
    Warehouse jpaToDomainPlain(WarehouseJpaEntity jpaEntity);

    @IterableMapping(qualifiedByName = WAREHOUSE_JPA_ENTITY_TO_DOMAIN_ENTITY_PLAIN)
    List<Warehouse> jpaToDomainPlain(List<WarehouseJpaEntity> jpaEntityList);

}

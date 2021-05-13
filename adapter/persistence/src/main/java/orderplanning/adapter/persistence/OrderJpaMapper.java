package orderplanning.adapter.persistence;

import orderplanning.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static orderplanning.adapter.persistence.ProductJpaMapper.PRODUCT_DOMAIN_ENTITY_TO_JPA_ENTITY;

@Mapper(uses = {
        ProductJpaMapper.class
})
interface OrderJpaMapper {

    @Mapping(target = "product", qualifiedByName = PRODUCT_DOMAIN_ENTITY_TO_JPA_ENTITY)
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "warehouse.id", source = "warehouseId")
    OrderJpaEntity domainEntityToJpaEntity(Order domainEntity, Long customerId, Long warehouseId);

    Order jpaToDomain(OrderJpaEntity jpaEntity);

}

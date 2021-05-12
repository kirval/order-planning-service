package orderplanning.adapter.persistence;

import orderplanning.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
interface OrderJpaMapper {

    /**
     * DOMAIN ENTITY TO JPA ENTITY MAPPINGS
     */
    String ORDER_DOMAIN_ENTITY_TO_JPA_ENTITY_PLAIN = "ORDER_DOMAIN_ENTITY_TO_JPA_ENTITY_PLAIN";

    @Named(ORDER_DOMAIN_ENTITY_TO_JPA_ENTITY_PLAIN)
    OrderJpaEntity domainEntityToJpaEntityPlain(Order domainEntity);

    /**
     * JPA ENTITY TO DOMAIN ENTITY
     */
    String JPA_ENTITY_TO_ORDER_DOMAIN_ENTITY_FULL = "JPA_ENTITY_TO_ORDER_DOMAIN_ENTITY_FULL";

    @Named(JPA_ENTITY_TO_ORDER_DOMAIN_ENTITY_FULL)
    Order jpaToDomainFull(OrderJpaEntity jpaEntity);

}

package orderplanning.adapter.persistence;

import orderplanning.domain.Customer;
import org.mapstruct.*;

import static orderplanning.adapter.persistence.OrderJpaMapper.JPA_ENTITY_TO_ORDER_DOMAIN_ENTITY_FULL;
import static orderplanning.adapter.persistence.OrderJpaMapper.ORDER_DOMAIN_ENTITY_TO_JPA_ENTITY_PLAIN;


@Mapper(uses = {
        OrderJpaMapper.class
})
interface CustomerJpaMapper {
    /**
     * DOMAIN TO JPA
     */
    String CUSTOMER_DOMAIN_ENTITY_TO_JPA_ENTITY_FULL = "CUSTOMER_DOMAIN_ENTITY_TO_JPA_ENTITY_FULL";

    @Named(CUSTOMER_DOMAIN_ENTITY_TO_JPA_ENTITY_FULL)
    @Mapping(target = "order", qualifiedByName = ORDER_DOMAIN_ENTITY_TO_JPA_ENTITY_PLAIN)
    CustomerJpaEntity domainEntityToJpaEntityFull(Customer domainEntity);

    @AfterMapping
    default void restoreBidirectionalRelations(@MappingTarget CustomerJpaEntity parent) {
        if (parent.getOrder() != null) {
            parent.getOrder().setCustomer(parent);
        }
    }

    /**
     * JPA ENTITY TO DOMAIN ENTITY
     */
    String JPA_ENTITY_TO_CUSTOMER_DOMAIN_ENTITY_FULL = "JPA_ENTITY_TO_CUSTOMER_DOMAIN_ENTITY_FULL";

    @Named(JPA_ENTITY_TO_CUSTOMER_DOMAIN_ENTITY_FULL)
    @Mapping(target = "order", qualifiedByName = JPA_ENTITY_TO_ORDER_DOMAIN_ENTITY_FULL)
    Customer jpaEntityToDomainEntityFull(CustomerJpaEntity jpaEntity);

}

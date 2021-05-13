package orderplanning.adapter.persistence;

import orderplanning.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(uses = {
        OrderJpaMapper.class
})
interface CustomerJpaMapper {
    /**
     * DOMAIN ENTITY TO JPA ENTITY
     */
    String CUSTOMER_DOMAIN_ENTITY_TO_JPA_ENTITY = "CUSTOMER_DOMAIN_ENTITY_TO_JPA_ENTITY";

    @Named(CUSTOMER_DOMAIN_ENTITY_TO_JPA_ENTITY)
    CustomerJpaEntity domainEntityToJpaEntity(Customer domainEntity);

    /**
     * JPA ENTITY TO DOMAIN ENTITY
     */
    String CUSTOMER_JPA_ENTITY_TO_DOMAIN_ENTITY_PLAIN = "CUSTOMER_JPA_ENTITY_TO_DOMAIN_ENTITY_PLAIN";

    @Named(CUSTOMER_JPA_ENTITY_TO_DOMAIN_ENTITY_PLAIN)
    @Mapping(target = "order", ignore = true)
    Customer jpaEntityToDomainEntityPlain(CustomerJpaEntity jpaEntity);

}

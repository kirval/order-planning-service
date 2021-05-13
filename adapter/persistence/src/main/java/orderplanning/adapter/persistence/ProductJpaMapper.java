package orderplanning.adapter.persistence;

import orderplanning.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
interface ProductJpaMapper {

    String PRODUCT_DOMAIN_ENTITY_TO_JPA_ENTITY = "PRODUCT_DOMAIN_ENTITY_TO_JPA_ENTITY";

    @Named(PRODUCT_DOMAIN_ENTITY_TO_JPA_ENTITY)
    ProductJpaEntity domainEntityToJpaEntity(Product domainEntity);

}

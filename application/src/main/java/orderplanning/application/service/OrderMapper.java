package orderplanning.application.service;

import orderplanning.application.port.in.PlaceOrderUseCaseDto;
import orderplanning.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface OrderMapper {

    /**
     * USE CASE DTO TO DOMAIN ENTITY MAPPINGS
     */
    String PLACE_ORDER_USE_CASE_DTO_TO_DOMAIN_ENTITY = "PLACE_ORDER_USE_CASE_DTO_TO_DOMAIN_ENTITY";

    @Named(PLACE_ORDER_USE_CASE_DTO_TO_DOMAIN_ENTITY)
    @Mapping(target = "product.id", source = "productId")
    Order useCaseDtoToDomainEntity(PlaceOrderUseCaseDto useCaseDto);

}

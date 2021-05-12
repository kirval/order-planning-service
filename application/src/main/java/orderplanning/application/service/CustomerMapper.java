package orderplanning.application.service;

import orderplanning.application.port.in.AddNewCustomerUseCaseDto;
import orderplanning.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface CustomerMapper {

    /**
     * USE CASE DTO TO DOMAIN ENTITY MAPPINGS
     */
    String ADD_NEW_CUSTOMER_USE_CASE_DTO_TO_DOMAIN_ENTITY = "ADD_NEW_CUSTOMER_USE_CASE_DTO_TO_DOMAIN_ENTITY";

    @Named(ADD_NEW_CUSTOMER_USE_CASE_DTO_TO_DOMAIN_ENTITY)
    Customer useCaseDtoToDomainEntity(AddNewCustomerUseCaseDto useCaseDto);

}

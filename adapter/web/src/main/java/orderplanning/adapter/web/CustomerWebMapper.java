package orderplanning.adapter.web;

import orderplanning.adapter.web.dto.CustomerDtoIn;
import orderplanning.adapter.web.dto.CustomerDtoOut;
import orderplanning.application.port.in.AddNewCustomerUseCaseDto;
import orderplanning.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
interface CustomerWebMapper {

    /**
     * WEB DTO TO USE CASE DTO MAPPINGS
     */
    String ADD_NEW_CUSTOMER_WEB_DTO_TO_USE_CASE_DTO = "ADD_NEW_CUSTOMER_WEB_DTO_TO_USE_CASE_DTO";

    @Named(ADD_NEW_CUSTOMER_WEB_DTO_TO_USE_CASE_DTO)
    AddNewCustomerUseCaseDto webDtoToUseCaseDto(CustomerDtoIn webDto);

    /**
     * DOMAIN TO WEB DTO MAPPINGS
     */
    String CUSTOMER_DOMAIN_TO_WEB_DTO = "CUSTOMER_DOMAIN_TO_WEB_DTO";

    @Named(ADD_NEW_CUSTOMER_WEB_DTO_TO_USE_CASE_DTO)
    CustomerDtoOut domainToWebDto(Customer domain);

}

package orderplanning.adapter.web;

import orderplanning.adapter.web.dto.CustomerDtoIn;
import orderplanning.adapter.web.dto.CustomerDtoOut;
import orderplanning.application.port.in.AddNewCustomerUseCaseDto;
import orderplanning.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
interface CustomerWebMapper {

    AddNewCustomerUseCaseDto webDtoToUseCaseDto(CustomerDtoIn webDto);

    CustomerDtoOut domainToWebDto(Customer domain);

}

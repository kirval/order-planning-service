package orderplanning.adapter.web;

import orderplanning.adapter.web.dto.CustomerDtoIn;
import orderplanning.adapter.web.dto.CustomerDtoOut;
import orderplanning.application.port.in.AddNewCustomerUseCase.AddNewCustomerUseCaseDto;
import orderplanning.domain.Customer;
import org.mapstruct.Mapper;

@Mapper
interface CustomerWebMapper {

    AddNewCustomerUseCaseDto webDtoToUseCaseDto(CustomerDtoIn webDto);

    CustomerDtoOut domainEntityToWebDto(Customer domain);

}

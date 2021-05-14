package orderplanning.application.service;

import orderplanning.application.port.in.AddNewCustomerUseCaseDto;
import orderplanning.domain.Customer;
import org.mapstruct.Mapper;

@Mapper
interface CustomerMapper {

    Customer useCaseDtoToDomainEntity(AddNewCustomerUseCaseDto useCaseDto);

}

package orderplanning.application.service;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.in.AddNewCustomerUseCase;
import orderplanning.application.port.in.AddNewCustomerUseCaseDto;
import orderplanning.application.port.out.CustomerPersistencePort;
import orderplanning.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
class CustomerService implements AddNewCustomerUseCase {

    private final CustomerPersistencePort customerPersistencePort;
    private final CustomerMapper customerMapper;

    @Override
    public Customer addNewCustomerUseCase(@Valid AddNewCustomerUseCaseDto newCustomerDto) {
        return customerPersistencePort.persistCustomer(customerMapper.useCaseDtoToDomainEntity(newCustomerDto));
    }

}

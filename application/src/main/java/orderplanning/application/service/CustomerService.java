package orderplanning.application.service;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.in.AddNewCustomerUseCase;
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
    public Customer addNewCustomer(@Valid AddNewCustomerUseCaseDto newCustomerDto) throws AddingCustomerException {
        try {
            return customerPersistencePort.persistCustomer(customerMapper.useCaseDtoToDomainEntity(newCustomerDto));
        } catch (Exception e) {
            throw new AddingCustomerException("Failed to add customer. " + e.getMessage());
        }
    }

}

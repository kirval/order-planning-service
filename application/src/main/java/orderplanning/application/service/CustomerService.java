package orderplanning.application.service;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.input.AddNewCustomerUseCase;
import orderplanning.application.port.output.CustomerPersistencePort;
import orderplanning.common.UseCase;
import orderplanning.common.exception.EntityManagementException;
import orderplanning.domain.Customer;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@UseCase
@Validated
@RequiredArgsConstructor
class CustomerService implements AddNewCustomerUseCase {

    private final CustomerPersistencePort customerPersistencePort;
    private final CustomerMapper customerMapper;

    @Override
    public Customer addNewCustomer(@Valid AddNewCustomerUseCaseDto newCustomerDto) throws EntityManagementException {
        try {
            return customerPersistencePort.persistCustomer(customerMapper.useCaseDtoToDomainEntity(newCustomerDto));
        } catch (Exception e) {
            throw new EntityManagementException("Failed to add customer. " + e.getMessage());
        }
    }

}

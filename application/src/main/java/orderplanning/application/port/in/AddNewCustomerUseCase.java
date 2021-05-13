package orderplanning.application.port.in;

import orderplanning.domain.Customer;

import javax.validation.Valid;

public interface AddNewCustomerUseCase {

    Customer addNewCustomer(@Valid AddNewCustomerUseCaseDto newCustomer);

}

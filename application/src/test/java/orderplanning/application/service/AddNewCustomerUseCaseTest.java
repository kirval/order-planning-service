package orderplanning.application.service;

import orderplanning.application.port.input.AddNewCustomerUseCase;
import orderplanning.application.port.input.AddNewCustomerUseCase.AddNewCustomerUseCaseDto;
import orderplanning.application.port.output.CustomerPersistencePort;
import orderplanning.common.exception.EntityManagementException;
import orderplanning.common.exception.PersistenceException;
import orderplanning.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddNewCustomerUseCaseTest {

    private AddNewCustomerUseCase addNewCustomerUseCase;
    @Mock
    private CustomerPersistencePort customerPersistencePort;

    @BeforeEach
    void initUseCase() {
        addNewCustomerUseCase = new CustomerService(customerPersistencePort, new CustomerMapperImpl());
    }

    @Test
    void testAddNewCustomer() throws PersistenceException, EntityManagementException {
        when(customerPersistencePort.persistCustomer(any(Customer.class)))
                .thenAnswer(invocation -> {
                    Customer argument = invocation.getArgument(0);
                    return new Customer()
                            .setId(1L)
                            .setName(argument.getName())
                            .setCoordinateX(argument.getCoordinateX())
                            .setCoordinateY(argument.getCoordinateY());
                });
        AddNewCustomerUseCaseDto customerToSave = new AddNewCustomerUseCaseDto()
                .setName("C1")
                .setCoordinateX(1)
                .setCoordinateY(1);
        assertDoesNotThrow(() -> addNewCustomerUseCase.addNewCustomer(customerToSave));

        Customer addedCustomer = addNewCustomerUseCase.addNewCustomer(customerToSave);
        assertThat(addedCustomer.getId()).isNotNull();
        assertThat(addedCustomer.getName()).isEqualTo(customerToSave.getName());
        assertThat(addedCustomer.getCoordinateX()).isEqualTo(customerToSave.getCoordinateX());
        assertThat(addedCustomer.getCoordinateY()).isEqualTo(customerToSave.getCoordinateY());
    }
}
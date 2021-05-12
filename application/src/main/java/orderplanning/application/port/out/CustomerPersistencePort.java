package orderplanning.application.port.out;

import orderplanning.domain.Customer;

public interface CustomerPersistencePort {

    Customer persistCustomer(Customer customer);

}

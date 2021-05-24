package orderplanning.application.port.output;

import orderplanning.common.exception.PersistenceException;
import orderplanning.domain.Customer;

public interface CustomerPersistencePort {

    Customer persistCustomer(Customer customer) throws PersistenceException;

}

package orderplanning.application.port.out;

import orderplanning.domain.Customer;

public interface CustomerQueryPort {

    Customer findById(Long id) throws IllegalArgumentException;

}

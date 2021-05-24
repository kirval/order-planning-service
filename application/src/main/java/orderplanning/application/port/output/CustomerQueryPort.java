package orderplanning.application.port.output;

import orderplanning.common.exception.QueryException;
import orderplanning.domain.Customer;

public interface CustomerQueryPort {

    Customer findById(Long id) throws QueryException;

}

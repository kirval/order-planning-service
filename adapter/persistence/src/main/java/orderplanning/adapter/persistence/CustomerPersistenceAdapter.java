package orderplanning.adapter.persistence;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.output.CustomerPersistencePort;
import orderplanning.application.port.output.CustomerQueryPort;
import orderplanning.common.PersistenceAdapter;
import orderplanning.common.exception.PersistenceException;
import orderplanning.common.exception.QueryException;
import orderplanning.domain.Customer;

@PersistenceAdapter
@RequiredArgsConstructor
class CustomerPersistenceAdapter implements CustomerPersistencePort, CustomerQueryPort {

    private final CustomerJpaRepository repository;
    private final CustomerJpaMapper mapper;

    @Override
    public Customer persistCustomer(Customer customer) throws PersistenceException {
        try {
            return mapper.jpaEntityToDomainEntityPlain(
                    repository.save(
                            mapper.domainEntityToJpaEntity(customer)));
        } catch (Exception e) {
            throw new PersistenceException("Failed to save Customer. " + e.getMessage());
        }
    }

    @Override
    public Customer findById(Long id) throws QueryException {
        return mapper.jpaEntityToDomainEntityPlain(repository.findById(id).orElseThrow(() ->
                new QueryException(String.format("Customer with id = {%s} is not found!", id))));
    }

}

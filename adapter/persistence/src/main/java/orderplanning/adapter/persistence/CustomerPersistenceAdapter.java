package orderplanning.adapter.persistence;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.out.CustomerPersistencePort;
import orderplanning.application.port.out.CustomerQueryPort;
import orderplanning.domain.Customer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CustomerPersistenceAdapter implements CustomerPersistencePort, CustomerQueryPort {

    private final CustomerJpaRepository repository;
    private final CustomerJpaMapper mapper;

    @Override
    public Customer persistCustomer(Customer customer) {
        return mapper.jpaEntityToDomainEntityPlain(
                repository.save(
                        mapper.domainEntityToJpaEntity(customer)));
    }

    @Override
    public Customer findById(Long id) throws IllegalArgumentException {
        return mapper.jpaEntityToDomainEntityPlain(repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Customer with id = {%s} is not found!", id))));
    }
}

package orderplanning.adapter.persistence;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.out.CustomerPersistencePort;
import orderplanning.domain.Customer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CustomerPersistenceAdapter implements CustomerPersistencePort {

    private final CustomerJpaRepository repository;
    private final CustomerJpaMapper mapper;

    @Override
    public Customer persistCustomer(Customer customer) {
        return mapper.jpaEntityToDomainEntityFull(
                repository.save(
                        mapper.domainEntityToJpaEntityFull(customer)));
    }

}

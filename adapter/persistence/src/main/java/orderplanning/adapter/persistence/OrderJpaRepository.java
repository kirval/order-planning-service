package orderplanning.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, Long> {
}

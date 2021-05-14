package orderplanning.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
interface WarehouseJpaRepository extends JpaRepository<WarehouseJpaEntity, Long>, JpaSpecificationExecutor<WarehouseJpaEntity> {
}

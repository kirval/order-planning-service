package orderplanning.adapter.persistence;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;

class WarehouseJpaSpecifications {

    public static Specification<WarehouseJpaEntity> findByContainingProduct(Long productId) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.join("products", JoinType.LEFT).get("id"), productId));
    }

}

package orderplanning.adapter.persistence;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "warehouses")
class WarehouseJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_generator")
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "customer_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "coordinateX", nullable = false)
    private Integer coordinateX;

    @Column(name = "coordinateY", nullable = false)
    private Integer coordinateY;

    @ManyToMany
    @JoinTable(name = "warehouse_product",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<ProductJpaEntity> products = new HashSet<>();

    @OneToMany(mappedBy = "warehouse")
    private Set<OrderJpaEntity> orders = new HashSet<>();
}

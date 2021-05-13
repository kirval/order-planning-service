package orderplanning.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Warehouse {

    private Long id;
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;

    /**
     * Products in stock
     */
    private Set<Product> products;

    /**
     * Picked up orders
     */
    private Set<Order> orders;

}

package orderplanning.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Warehouse {

    private Long id;
    private Long name;
    private Float latitude;
    private Float longitude;

    /**
     * Products in stock
     */
    private Set<Product> products;

    /**
     * Picked up orders
     */
    private Set<Order> orders;

}

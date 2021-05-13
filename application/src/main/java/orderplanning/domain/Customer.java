package orderplanning.domain;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;

    /**
     * For simplicity, let's assume that the customer may have only one order
     */
    private Order order;

}

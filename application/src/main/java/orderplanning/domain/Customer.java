package orderplanning.domain;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
    private Order order;

}

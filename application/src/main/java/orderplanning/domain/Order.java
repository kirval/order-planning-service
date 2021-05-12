package orderplanning.domain;

import lombok.Data;

@Data
public class Order {

    private Long id;

    /**
     * For simplicity, let's assume that the order contains only one product
     */
    private Product product;

}

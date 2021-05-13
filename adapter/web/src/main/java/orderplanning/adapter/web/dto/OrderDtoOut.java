package orderplanning.adapter.web.dto;

import lombok.Data;

@Data
public class OrderDtoOut {

    private Long orderId;
    private Long warehouseId;
    private String warehouseName;
    private Double distance;

}

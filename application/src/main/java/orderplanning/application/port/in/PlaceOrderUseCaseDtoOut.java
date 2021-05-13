package orderplanning.application.port.in;

import lombok.Data;
import orderplanning.domain.Warehouse;

import javax.validation.constraints.NotNull;

@Data
public class PlaceOrderUseCaseDtoOut {

    private Long orderId;
    private Long warehouseId;
    private String warehouseName;
    private Double distance;

}

package orderplanning.application.port.in;

import lombok.Data;
import orderplanning.application.service.OrderPlacingException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface PlaceOrderUseCase {

    PlaceOrderUseCaseDtoOut placeOrder(@Valid PlaceOrderUseCaseDtoIn placeOrderDto) throws OrderPlacingException;

    @Data
    class PlaceOrderUseCaseDtoIn {

        @NotNull
        private Long customerId;

        @NotNull
        private Long productId;

    }

    @Data
    class PlaceOrderUseCaseDtoOut {

        private Long orderId;
        private Long warehouseId;
        private String warehouseName;
        private Double distance;

    }

}

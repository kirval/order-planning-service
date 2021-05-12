package orderplanning.application.port.in;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PlaceOrderUseCaseDto {

    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;

}

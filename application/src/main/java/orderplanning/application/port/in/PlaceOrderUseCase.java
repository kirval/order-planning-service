package orderplanning.application.port.in;

import javax.validation.Valid;

public interface PlaceOrderUseCase {

    PlaceOrderUseCaseDtoOut placeOrder(@Valid PlaceOrderUseCaseDtoIn placeOrderDto);

}

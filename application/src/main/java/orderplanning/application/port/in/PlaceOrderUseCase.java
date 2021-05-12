package orderplanning.application.port.in;

import javax.validation.Valid;

public interface PlaceOrderUseCase {

    void placeOrderUseCase(@Valid PlaceOrderUseCaseDto order);

}

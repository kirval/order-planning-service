package orderplanning.adapter.web;

import lombok.RequiredArgsConstructor;
import orderplanning.adapter.web.dto.OrderDtoIn;
import orderplanning.adapter.web.dto.OrderDtoOut;
import orderplanning.application.port.in.PlaceOrderUseCase;
import orderplanning.application.port.in.PlaceOrderUseCaseDtoOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final PlaceOrderUseCase placeOrderUseCase;
    private final OrderWebMapper mapper;

    @PostMapping
    public ResponseEntity<OrderDtoOut> placeOrder(@Valid @RequestBody OrderDtoIn dto) {
        PlaceOrderUseCaseDtoOut placedOrder = placeOrderUseCase.placeOrder(mapper.webDtoToUseCaseDto(dto));
        return new ResponseEntity<>(mapper.useCaseDtoToWebDto(placedOrder), HttpStatus.CREATED);
    }

}

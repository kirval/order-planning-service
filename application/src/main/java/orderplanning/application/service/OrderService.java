package orderplanning.application.service;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.in.PlaceOrderUseCase;
import orderplanning.application.port.in.PlaceOrderUseCaseDto;
import orderplanning.application.port.out.OrderPersistencePort;
import orderplanning.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
class OrderService implements PlaceOrderUseCase {

//    private final OrderPersistencePort orderPersistencePort;
    private final OrderMapper orderMapper;

    @Override
    public void placeOrderUseCase(@Valid PlaceOrderUseCaseDto orderDto) {
        //найти склад по критериям:
        //  1. продукт в наличии
        //  2. ближайший до кастомера
        Order order = orderMapper.useCaseDtoToDomainEntity(orderDto);
//        orderPersistencePort.persistOrder(order, orderDto.getCustomerId());
    }

}

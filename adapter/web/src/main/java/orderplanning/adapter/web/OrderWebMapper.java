package orderplanning.adapter.web;

import orderplanning.adapter.web.dto.OrderDtoIn;
import orderplanning.adapter.web.dto.OrderDtoOut;
import orderplanning.application.port.input.PlaceOrderUseCase.PlaceOrderUseCaseDtoIn;
import orderplanning.application.port.input.PlaceOrderUseCase.PlaceOrderUseCaseDtoOut;
import org.mapstruct.Mapper;

@Mapper
interface OrderWebMapper {

    PlaceOrderUseCaseDtoIn webDtoToUseCaseDto(OrderDtoIn webDto);

    OrderDtoOut useCaseDtoToWebDto(PlaceOrderUseCaseDtoOut useCaseDto);

}

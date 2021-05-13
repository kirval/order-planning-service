package orderplanning.adapter.web;

import orderplanning.adapter.web.dto.OrderDtoIn;
import orderplanning.adapter.web.dto.OrderDtoOut;
import orderplanning.application.port.in.PlaceOrderUseCaseDtoIn;
import orderplanning.application.port.in.PlaceOrderUseCaseDtoOut;
import org.mapstruct.Mapper;

@Mapper
interface OrderWebMapper {

    PlaceOrderUseCaseDtoIn webDtoToUseCaseDto(OrderDtoIn webDto);

    OrderDtoOut useCaseDtoToWebDto(PlaceOrderUseCaseDtoOut useCaseDto);

}

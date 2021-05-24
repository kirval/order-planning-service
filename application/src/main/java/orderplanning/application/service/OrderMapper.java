package orderplanning.application.service;

import orderplanning.application.port.input.PlaceOrderUseCase.PlaceOrderUseCaseDtoOut;
import orderplanning.domain.Order;
import orderplanning.domain.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface OrderMapper {

    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "warehouseId", source = "warehouse.id")
    @Mapping(target = "warehouseName", source = "warehouse.name")
    PlaceOrderUseCaseDtoOut domainEntityToUseCaseDto(Order order, Warehouse warehouse, Double distance);

}

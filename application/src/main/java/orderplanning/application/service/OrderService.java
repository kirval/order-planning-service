package orderplanning.application.service;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.input.PlaceOrderUseCase;
import orderplanning.application.port.output.CustomerQueryPort;
import orderplanning.application.port.output.OrderPersistencePort;
import orderplanning.application.port.output.WarehouseQueryPort;
import orderplanning.common.UseCase;
import orderplanning.common.exception.EntityManagementException;
import orderplanning.domain.Customer;
import orderplanning.domain.Order;
import orderplanning.domain.Product;
import orderplanning.domain.Warehouse;
import org.javatuples.Pair;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@UseCase
@Validated
@RequiredArgsConstructor
class OrderService implements PlaceOrderUseCase {

    private final OrderPersistencePort orderPersistencePort;
    private final OrderMapper orderMapper;
    private final CustomerQueryPort customerQueryPort;
    private final WarehouseQueryPort warehouseQueryPort;

    @Override
    public PlaceOrderUseCaseDtoOut placeOrder(@Valid PlaceOrderUseCaseDtoIn placeOrderDto) throws EntityManagementException {
        try {
            Customer customer = customerQueryPort.findById(placeOrderDto.getCustomerId());
            List<Warehouse> warehouses = warehouseQueryPort.findWarehousesContainingProduct(placeOrderDto.getProductId());
            Pair<Warehouse, Double> closestWarehouseWithDistance = getClosestWarehouseToCoordinates(warehouses,
                    customer.getCoordinateX(), customer.getCoordinateY());
            Order placedOrder = orderPersistencePort.persistOrder(new Order().setProduct(
                    new Product().setId(placeOrderDto.getProductId())),
                    customer.getId(),
                    closestWarehouseWithDistance.getValue0().getId()
            );
            return orderMapper.domainEntityToUseCaseDto(placedOrder, closestWarehouseWithDistance.getValue0(),
                    closestWarehouseWithDistance.getValue1());
        } catch (Exception e) {
            throw new EntityManagementException("Failed to add order. " + e.getMessage());
        }
    }

    private Pair<Warehouse, Double> getClosestWarehouseToCoordinates(List<Warehouse> warehouses,
                                                                     int coordinateX,
                                                                     int coordinateY) throws Exception {
        if (warehouses == null || warehouses.size() == 0) {
            throw new Exception("Empty warehouses list.");
        }
        Warehouse closestWarehouse = null;
        Double closestDistance = null;
        for (Warehouse warehouse : warehouses) {
            double distance = calculateDistanceWithPythagorasTheorem(
                    warehouse.getCoordinateX(), warehouse.getCoordinateY(), coordinateX, coordinateY);
            if (closestDistance == null) {
                closestDistance = distance;
                closestWarehouse = warehouse;
            } else if (distance < closestDistance) {
                closestDistance = distance;
                closestWarehouse = warehouse;
            }
        }
        return new Pair<>(closestWarehouse, closestDistance);
    }

    private double calculateDistanceWithPythagorasTheorem(int x1, int y1, int x2, int y2) {
        int lengthX = x1 - x2;
        int lengthY = y1 - y2;
        return Math.sqrt((lengthX * lengthX) + (lengthY * lengthY));
    }

}
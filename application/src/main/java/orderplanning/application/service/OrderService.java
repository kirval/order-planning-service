package orderplanning.application.service;

import lombok.RequiredArgsConstructor;
import orderplanning.application.port.in.PlaceOrderUseCase;
import orderplanning.application.port.out.CustomerQueryPort;
import orderplanning.application.port.out.OrderPersistencePort;
import orderplanning.application.port.out.WarehouseQueryPort;
import orderplanning.domain.Customer;
import orderplanning.domain.Order;
import orderplanning.domain.Product;
import orderplanning.domain.Warehouse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Map.Entry;

@Service
@Validated
@RequiredArgsConstructor
class OrderService implements PlaceOrderUseCase {

    private final OrderPersistencePort orderPersistencePort;
    private final OrderMapper orderMapper;
    private final CustomerQueryPort customerQueryPort;
    private final WarehouseQueryPort warehouseQueryPort;

    @Override
    public PlaceOrderUseCaseDtoOut placeOrder(@Valid PlaceOrderUseCaseDtoIn placeOrderDto) throws OrderPlacingException {
        try {
            Customer customer = customerQueryPort.findById(placeOrderDto.getCustomerId());
            List<Warehouse> warehouses = warehouseQueryPort.findWarehousesContainingProduct(placeOrderDto.getProductId());
            Entry<Double, Warehouse> closestWarehouseWithDistance = findClosestWarehouseToCoordinates(warehouses,
                    customer.getCoordinateX(), customer.getCoordinateY());
            Order placedOrder = orderPersistencePort.persistOrder(new Order()
                            .setProduct(new Product().setId(placeOrderDto.getProductId())),
                    customer.getId(),
                    closestWarehouseWithDistance.getValue().getId()
            );

            return orderMapper.domainEntityToUseCaseDto(placedOrder, closestWarehouseWithDistance.getValue(), closestWarehouseWithDistance.getKey());
        } catch (Exception e) {
            throw new OrderPlacingException("Failed to place order. " + e.getMessage());
        }
    }

    private Entry<Double, Warehouse> findClosestWarehouseToCoordinates(List<Warehouse> warehouses, int coordinateX, int coordinateY) {
        if (warehouses == null || warehouses.size() == 0) {
            throw new RuntimeException("Empty warehouses list.");
        }
        Warehouse closestWarehouse = null;
        Double closestDistance = null;
        for (Warehouse warehouse : warehouses) {
            double distance = calculateDistanceWithPythagorasTheorem(warehouse.getCoordinateX(), warehouse.getCoordinateY(),
                    coordinateX, coordinateY);
            if (closestDistance == null) {
                closestDistance = distance;
                closestWarehouse = warehouse;
            } else if (distance < closestDistance) {
                closestDistance = distance;
                closestWarehouse = warehouse;
            }
        }

        return new SimpleImmutableEntry<>(closestDistance, closestWarehouse);
    }

    private double calculateDistanceWithPythagorasTheorem(int x1, int y1, int x2, int y2) {
        int lengthX = x1 - x2;
        int lengthY = y1 - y2;

        return Math.sqrt((lengthX * lengthX) + (lengthY * lengthY));
    }

}
package orderplanning.application.service;

import orderplanning.application.port.in.PlaceOrderUseCase;
import orderplanning.application.port.in.PlaceOrderUseCase.PlaceOrderUseCaseDtoIn;
import orderplanning.application.port.in.PlaceOrderUseCase.PlaceOrderUseCaseDtoOut;
import orderplanning.application.port.out.CustomerQueryPort;
import orderplanning.application.port.out.OrderPersistencePort;
import orderplanning.application.port.out.WarehouseQueryPort;
import orderplanning.domain.Customer;
import orderplanning.domain.Order;
import orderplanning.domain.Product;
import orderplanning.domain.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaceOrderUseCaseTest {

    private PlaceOrderUseCase placeOrderUseCase;
    @Mock
    private OrderPersistencePort orderPersistencePort;
    @Mock
    private CustomerQueryPort customerQueryPort;
    @Mock
    private WarehouseQueryPort warehouseQueryPort;

    @BeforeEach
    void initUseCase() {
        placeOrderUseCase = new OrderService(orderPersistencePort, new OrderMapperImpl(), customerQueryPort, warehouseQueryPort);
    }

    @Test
    void testPlaceOrder() throws OrderPlacingException {
        when(warehouseQueryPort.findWarehousesContainingProduct(anyLong())).thenReturn(
                Collections.singletonList(new Warehouse()
                        .setId(1L)
                        .setName("WH1")
                        .setCoordinateX(1)
                        .setCoordinateY(1))
        );
        when(customerQueryPort.findById(anyLong())).thenAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            return new Customer()
                    .setId(id)
                    .setName("C1")
                    .setCoordinateX(1)
                    .setCoordinateY(1);
        });
        when(orderPersistencePort.persistOrder(any(Order.class), anyLong(), anyLong())).thenAnswer(invocation -> {
            Order order = invocation.getArgument(0);
            return new Order()
                    .setId(1L)
                    .setProduct(new Product().setId(order.getProduct().getId()));
        });
        PlaceOrderUseCaseDtoIn orderToPlace = new PlaceOrderUseCaseDtoIn()
                .setCustomerId(1L)
                .setProductId(1L);
        PlaceOrderUseCaseDtoOut placedOrder = placeOrderUseCase.placeOrder(orderToPlace);

        assertDoesNotThrow(() -> placeOrderUseCase.placeOrder(orderToPlace));
        assertThat(placedOrder.getOrderId()).isEqualTo(1L);
        assertThat(placedOrder.getWarehouseId()).isEqualTo(1L);
        assertThat(placedOrder.getWarehouseName()).isEqualTo("WH1");
        assertThat(placedOrder.getDistance()).isEqualTo(0.0);
    }
}
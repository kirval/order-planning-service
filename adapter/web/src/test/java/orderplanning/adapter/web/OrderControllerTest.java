package orderplanning.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import orderplanning.adapter.web.dto.OrderDtoOut;
import orderplanning.application.port.in.PlaceOrderUseCase;
import orderplanning.application.port.in.PlaceOrderUseCase.PlaceOrderUseCaseDtoIn;
import orderplanning.application.port.in.PlaceOrderUseCase.PlaceOrderUseCaseDtoOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderController.class)
@Import(OrderWebMapperImpl.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PlaceOrderUseCase placeOrderUseCase;


    @Test
    void testPlaceOrder() throws Exception {
        when(placeOrderUseCase.placeOrder(any(PlaceOrderUseCaseDtoIn.class)))
                .thenReturn(new PlaceOrderUseCaseDtoOut()
                        .setOrderId(1L)
                        .setWarehouseId(1L)
                        .setWarehouseName("WH1")
                        .setDistance(1.0));

        PlaceOrderUseCaseDtoIn dtoIn = new PlaceOrderUseCaseDtoIn()
                .setCustomerId(1L)
                .setProductId(1L);

        String actualDtoOut = mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoIn)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse().getContentAsString();

        OrderDtoOut expectedDtoOut = new OrderDtoOut()
                .setOrderId(1L)
                .setWarehouseId(1L)
                .setWarehouseName("WH1")
                .setDistance(1.0);

        verify(placeOrderUseCase, times(1)).placeOrder(any(PlaceOrderUseCaseDtoIn.class));
        assertThat(actualDtoOut).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectedDtoOut));
    }


}
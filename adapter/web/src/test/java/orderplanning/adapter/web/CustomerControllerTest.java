package orderplanning.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import orderplanning.adapter.web.dto.CustomerDtoIn;
import orderplanning.adapter.web.dto.CustomerDtoOut;
import orderplanning.application.port.in.AddNewCustomerUseCase;
import orderplanning.application.port.in.AddNewCustomerUseCase.AddNewCustomerUseCaseDto;
import orderplanning.domain.Customer;
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

@WebMvcTest(controllers = CustomerController.class)
@Import(CustomerWebMapperImpl.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AddNewCustomerUseCase addNewCustomerUseCase;

    @Test
    void testAddNewCustomer() throws Exception {
        when(addNewCustomerUseCase.addNewCustomer(any(AddNewCustomerUseCaseDto.class)))
                .thenAnswer(invocation -> {
                    AddNewCustomerUseCaseDto useCaseDto = invocation.getArgument(0);
                    return new Customer()
                            .setId(1L)
                            .setName(useCaseDto.getName())
                            .setCoordinateX(useCaseDto.getCoordinateX())
                            .setCoordinateY(useCaseDto.getCoordinateY());
                });

        CustomerDtoIn dtoIn = new CustomerDtoIn()
                .setName("C1")
                .setCoordinateX(1)
                .setCoordinateY(1);

        String actualDtoOut = mockMvc.perform(post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoIn)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse().getContentAsString();

        CustomerDtoOut expectedDtoOut = new CustomerDtoOut()
                .setId(1L)
                .setName("C1")
                .setCoordinateX(1)
                .setCoordinateY(1);

        verify(addNewCustomerUseCase, times(1)).addNewCustomer(any(AddNewCustomerUseCaseDto.class));
        assertThat(actualDtoOut).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectedDtoOut));
    }

}
package orderplanning.application.port.in;

import lombok.Data;
import orderplanning.application.service.AddingCustomerException;
import orderplanning.domain.Customer;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface AddNewCustomerUseCase {

    Customer addNewCustomer(@Valid AddNewCustomerUseCaseDto newCustomer) throws AddingCustomerException;

    @Data
    class AddNewCustomerUseCaseDto {

        @NotBlank
        private String name;

        @NotNull
        private Integer coordinateX;

        @NotNull
        private Integer coordinateY;

    }

}

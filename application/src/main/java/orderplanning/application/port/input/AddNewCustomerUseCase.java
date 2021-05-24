package orderplanning.application.port.input;

import lombok.Data;
import orderplanning.common.exception.EntityManagementException;
import orderplanning.domain.Customer;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface AddNewCustomerUseCase {

    Customer addNewCustomer(@Valid AddNewCustomerUseCaseDto newCustomer) throws EntityManagementException;

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

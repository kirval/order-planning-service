package orderplanning.application.port.in;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddNewCustomerUseCaseDto {

    @NotBlank
    private String name;

    @NotNull
    private Float latitude;

    @NotNull
    private Float longitude;

}

package orderplanning.application.port.in;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddNewCustomerUseCaseDto {

    @NotBlank
    private String name;

    @NotNull
    private Integer coordinateX;

    @NotNull
    private Integer coordinateY;

}

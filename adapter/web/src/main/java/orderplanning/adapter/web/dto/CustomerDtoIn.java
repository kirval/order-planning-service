package orderplanning.adapter.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CustomerDtoIn {

    @NotBlank
    private String name;

    @NotNull
    private Integer coordinateX;

    @NotNull
    private Integer coordinateY;

}

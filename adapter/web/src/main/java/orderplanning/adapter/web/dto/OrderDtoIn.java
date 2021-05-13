package orderplanning.adapter.web.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDtoIn {

    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;

}

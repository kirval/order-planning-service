package orderplanning.adapter.web.dto;

import lombok.Data;

@Data
public class CustomerDtoOut {

    private Long id;
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;

}

package orderplanning.adapter.web.dto;

import lombok.Data;

@Data
public class CustomerDtoOut {

    private Long id;
    private String name;
    private Float latitude;
    private Float longitude;

}

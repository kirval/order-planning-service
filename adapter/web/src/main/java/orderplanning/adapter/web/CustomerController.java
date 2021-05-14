package orderplanning.adapter.web;

import lombok.RequiredArgsConstructor;
import orderplanning.adapter.web.dto.CustomerDtoIn;
import orderplanning.adapter.web.dto.CustomerDtoOut;
import orderplanning.application.port.in.AddNewCustomerUseCase;
import orderplanning.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final AddNewCustomerUseCase addNewCustomerUseCase;
    private final CustomerWebMapper mapper;

    @PostMapping
    public ResponseEntity<CustomerDtoOut> addNewCustomer(@Valid @RequestBody CustomerDtoIn dto) {
        try {
            Customer addedCustomer = addNewCustomerUseCase.addNewCustomer(mapper.webDtoToUseCaseDto(dto));
            return new ResponseEntity<>(mapper.domainEntityToWebDto(addedCustomer), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Failed to add customer. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

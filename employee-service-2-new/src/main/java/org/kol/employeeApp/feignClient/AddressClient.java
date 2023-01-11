package org.kol.employeeApp.feignClient;

import org.kol.employeeApp.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "address-service", url = "http://localhost:8081/address-app/api/")
public interface AddressClient { //proxy class
    //http://localhost:8081/address-app/api/address/1

    @GetMapping("/address/{id}") //then 2- went here

    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id); //1-id came here
    // public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id)
}

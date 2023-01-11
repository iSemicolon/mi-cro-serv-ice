package org.kol.employeeApp.service;

import org.kol.employeeApp.entity.Employee;
import org.kol.employeeApp.repository.EmployeeRepo;
import org.kol.employeeApp.response.AddressResponse;
import org.kol.employeeApp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

//@Value("${addresservice.base.url}")
//private String addressBaseURL;

/*
altervative way to use resttemplate

//@Autowired no need
    private RestTemplate restTemplate;




//    public EmployeeService (@Value("${addresservice.base.url}" String addressBaseURL, RestTemplateBuilder builder) {
//
      this.restTemplate=builder.rootUri(addressBaseURL).build(); // initialise rest template
//    }

 */

    public EmployeeResponse getEmployeesById(int id) {
        //set data by rest api call
         AddressResponse addressResponse= new AddressResponse();
        Employee employee=employeeRepo.findById(id).get(); //dbcall

//        EmployeeResponse employeeResponse= new EmployeeResponse()
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setEmail(employee.getEmail());
//        employeeResponse.setBloodGroup(employee.getBloodGroup());

        // alternative is modelmapper

        EmployeeResponse employeeResponse=  modelMapper.map(employee, EmployeeResponse.class);

      //  String url="http://localhost:8081/address-app/api/address/{id}";
     //   int urivariable=id;
      //  String response="AddressResponse.class";
      //  restTemplate.getForObject(url,response, urivariable);
       // addressResponse=restTemplate.getForObject("http://localhost:8081/address-app/api/address/{id}",AddressResponse.class, id);
   //-->>>     addressResponse=restTemplate.getForObject(addressBaseURL+"/address/{id}",AddressResponse.class, id);

        //using webclient
        addressResponse =webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();

//externaal service call
        employeeResponse.setAddressResponse(addressResponse);

       return employeeResponse;

   }

//   private  AddressResponse callingAddressServiceUsingRest(int id){
//        return restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
//   }

    }

package org.kol.employeeApp.service;

import org.kol.employeeApp.entity.Employee;
import org.kol.employeeApp.feignClient.AddressClient;
import org.kol.employeeApp.repository.EmployeeRepo;
import org.kol.employeeApp.response.AddressResponse;
import org.kol.employeeApp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Autowired
    private AddressClient addressClient;






    public EmployeeResponse getEmployeesById(int id) {

        Employee employee=employeeRepo.findById(id).get(); //dbcall



        EmployeeResponse employeeResponse=  modelMapper.map(employee, EmployeeResponse.class);


        AddressResponse addressResponse =addressClient.getAddressByEmployeeId(id);

        employeeResponse.setAddressResponse(addressResponse);

       return employeeResponse;

   }



    }

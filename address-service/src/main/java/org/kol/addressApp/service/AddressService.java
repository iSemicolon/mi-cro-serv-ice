package org.kol.addressApp.service;

import org.kol.addressApp.entity.Address;
import org.kol.addressApp.repository.AddressRepo;
import org.kol.addressApp.response.AddressResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;


//    public Employee getEmployeesById(int id) {
//        Employee employee=employeeRepo.findById(id).get();
//        return employee;
//
//    }

    public AddressResponse findAddresByEmployeeId(int employeeId) {
       // Employee employee=employeeRepo.findById(id).get();

//        EmployeeResponse employeeResponse= new EmployeeResponse()
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setEmail(employee.getEmail());
//        employeeResponse.setBloodGroup(employee.getBloodGroup());

        // alternative is modelmapper

        Address address=addressRepo.findAddressByEmployeeId(employeeId);

        AddressResponse addressResponse=  modelMapper.map(address, AddressResponse.class);

       return addressResponse;

   }


    }

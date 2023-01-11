package org.kol.employeeApp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeAppConfig {

    @Value("${addresservice.base.url}")
    private String addressBaseURL;

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }


}

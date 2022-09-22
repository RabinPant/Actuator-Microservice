package com.rabinpant.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabinpant.DTO.Employee;
import com.rabinpant.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmployeeController {


   /* @GetMapping("/health")
    public HttpStatus getHealth(){
        return HttpStatus.OK;
    }*/
    @Autowired
    private EmployeeService service;

     Logger log = LoggerFactory.getLogger(EmployeeController.class);


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() throws JsonProcessingException {
        List<Employee> employee = service.getEmployee();
        log.info("EmployeeCntroller:getAllEmployee fetch all employee",new ObjectMapper().writeValueAsString(employee));
        return employee;
    }


}

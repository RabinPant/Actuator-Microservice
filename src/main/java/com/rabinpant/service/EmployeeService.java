package com.rabinpant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabinpant.DTO.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class EmployeeService {

    public List<Employee> getEmployee() throws JsonProcessingException {

        List<Employee> collect = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Employee(i, "Employee" + i)).collect(Collectors.toList());

        log.info("EmployeeService:getEmployees find all employees from system {}",new ObjectMapper().writeValueAsString(collect));
        return collect;
    }
}

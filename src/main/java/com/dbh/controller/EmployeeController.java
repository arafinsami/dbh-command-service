package com.dbh.controller;

import com.dbh.entity.Employee;
import com.dbh.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Employee Command API")
@RequestMapping(path = "dbh-employee-command")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @Operation(summary = "save an employee")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        Employee employeeResponse = employeeService.save(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee employeeResponse = employeeService.save(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete employee by id")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
        log.info("delete employee by id {}", id);
    }
}

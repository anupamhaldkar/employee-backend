package com.employee.backend.controller;

import com.employee.backend.model.Employee;
import com.employee.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
       Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee employee){
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);

    }
}

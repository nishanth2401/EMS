package com.excelr.mainpackage.controller;

import com.excelr.mainpackage.model.Employee;
import com.excelr.mainpackage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        if(employeeRepository.existsById(id)){
            return employeeRepository.findById(id);
        }
        else{
            throw new RuntimeException("Employee not found, "+id);
        }
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println("Received POST request for creating employee: " + employee);
        return employeeRepository.save(employee);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee=employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee doest not exist with id: "+id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setAddress(employeeDetails.getAddress());
        updateEmployee.setSalary(employeeDetails.getSalary());
        updateEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        updateEmployee.setDepartment(employeeDetails.getDepartment());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        System.out.println("Fetching employees for department: " + department);
        List<Employee> employees = employeeRepository.findByDepartment(department);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found for department: " + department);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            System.out.println("Employees found for department: " + department);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }
    @DeleteMapping("{id}")
   public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("\"Employee doest not exist with id: \"+id"));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

   }

    @ExceptionHandler(RuntimeException.class)
    public String exceptionResponce(RuntimeException runtimeException){
        return runtimeException.getMessage();
    }
}


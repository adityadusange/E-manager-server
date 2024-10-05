package com.company.employers;


import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmplController {
  @Autowired
  EmployeeService employeeService ;

  @GetMapping("/employee") 
    public List<Employee> getAllEmployees() {
       
      return employeeService.readAllEmployees();
    }
  @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee) {
      return employeeService.creatEmployee(employee);
        
        
       
    }
  @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployeeById(id);
    }
  @DeleteMapping("/employee/{id}")
    public String deleteemployee(@PathVariable Long id){
        if (employeeService.deleteEmployee(id)) {
          return "user deleted succesfully";
          
        }
        else{
          return "Something went wrong";
        }
        
    }
     @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployeeById(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Return 404 if employee not found
        }
    }

    
}

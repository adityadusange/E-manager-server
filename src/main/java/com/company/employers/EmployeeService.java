package com.company.employers;
import java.util.*;

import org.springframework.stereotype.Service;
@Service
public interface EmployeeService {
    String creatEmployee(Employee employee);
    List<Employee> readAllEmployees();
    boolean deleteEmployee(Long id);
    Employee readEmployeeById(Long id);
    Employee updateEmployeeById(Long id, Employee updatedEmployee);
    
}

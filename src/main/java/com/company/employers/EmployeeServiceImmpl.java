package com.company.employers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImmpl implements EmployeeService {

    @Autowired
    private EmployersRepo employersRepo;
    List<Employee> employee = new ArrayList<>();

    @Override
    public String creatEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employersRepo.save(employeeEntity);
        return "storeed";
    }

    @Override
    public List<Employee> readAllEmployees() {
        List<EmployeeEntity> employeesList = employersRepo.findAll();
        List<Employee> employee = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhone(employeeEntity.getPhone());
            emp.setEmail(employeeEntity.getEmail());

            employee.add(emp);

        }
        return employee;
    }

    @Override
    public Employee readEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntityOptional = employersRepo.findById(id);

        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();

            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhone(employeeEntity.getPhone());
            emp.setEmail(employeeEntity.getEmail());

            return emp;
        }
        return null; 
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employersRepo.findById(id).get();

        employersRepo.delete(emp);
        return true;

    }
    @Override
    public Employee updateEmployeeById(Long id, Employee updatedEmployee) {
        Optional<EmployeeEntity> employeeEntityOptional = employersRepo.findById(id);
    
        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity existingEmployeeEntity = employeeEntityOptional.get();
    
            existingEmployeeEntity.setName(updatedEmployee.getName());
            existingEmployeeEntity.setPhone(updatedEmployee.getPhone());
            existingEmployeeEntity.setEmail(updatedEmployee.getEmail());
    
            EmployeeEntity savedEntity = employersRepo.save(existingEmployeeEntity);
    
            Employee employee = new Employee();
            BeanUtils.copyProperties(savedEntity, employee);
    
            return employee;
        } else {
            return null; 
        }
    }
    

}

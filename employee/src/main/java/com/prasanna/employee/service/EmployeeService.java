package com.prasanna.employee.service;

import com.prasanna.employee.model.Employee;
import com.prasanna.employee.repositary.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }


    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Employee updateEmployee(Long id, Employee newEmployee) {
        Employee existingEmployee = repository.findById(id).orElse(null);

        if (existingEmployee != null) {
            existingEmployee.setName(newEmployee.getName());
            existingEmployee.setRole(newEmployee.getRole());
            existingEmployee.setSalary(newEmployee.getSalary());
            return repository.save(existingEmployee);
        }
        return null;
    }


    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

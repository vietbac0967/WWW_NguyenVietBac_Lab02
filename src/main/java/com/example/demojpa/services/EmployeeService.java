package com.example.demojpa.services;

import com.example.demojpa.enums.EmployeeStatus;
import com.example.demojpa.models.Employee;
import com.example.demojpa.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final   EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee) {
        employeeRepository.insertEmp(employee);
    }

    public boolean deleteEmp(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            final var employeeStatus = EmployeeStatus.IN_ACTIVE;
            employeeRepository.setStatus(emp,employeeStatus);
            employeeRepository.update(emp);
            return true;
        }
        return false;
    }

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public boolean activeEmp(long id) {
        Optional<Employee> op = employeeRepository.findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setEmployeeStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAll() {
        return employeeRepository.getAllEmp();
    }

}

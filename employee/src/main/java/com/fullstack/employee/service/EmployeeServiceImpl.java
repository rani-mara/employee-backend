package com.fullstack.employee.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fullstack.employee.entity.EmployeeEntity;
import com.fullstack.employee.model.Employee;
import com.fullstack.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeEntity,employee);
        employeeRepository.save(employeeEntity);
        return employee;
    }
    public List<Employee> getAllEmployees(){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = employeeEntities.stream().map(emp ->new Employee(
                emp.getId(),
                emp.getOrganizationName(),
                emp.getEmailId(),
                emp.getPurpose(),
                emp.getStudentId())).collect(Collectors.toList());

        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
       EmployeeEntity employeeEntity;
       employeeEntity =employeeRepository.findById(id).get();
       Employee employee = new Employee();
       BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setOrganizationName(employee.getOrganizationName());
        employeeEntity.setEmailId(employee.getEmailId());
         employeeEntity.setPurpose(employee.getPurpose());
         employeeEntity.setStudentId(employee.getStudentId());
         employeeRepository.save(employeeEntity);
         return employee;
    }
}

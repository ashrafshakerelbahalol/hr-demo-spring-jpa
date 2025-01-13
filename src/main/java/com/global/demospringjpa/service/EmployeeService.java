package com.global.demospringjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.global.demospringjpa.Entity.Employee;
import com.global.demospringjpa.Repository.EmployeeRepository;
import com.global.demospringjpa.projection.EmployeeProjection;
import com.global.demospringjpa.projection.HrStatistic;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserService userService;

    public List<EmployeeProjection> findBySalary(Double salary) {
        return employeeRepository.findBySalary(salary);
    }

    public Page<EmployeeProjection> findByName(String name, boolean isAsc, String col, int pageNum, int pageSize) {
                if (name.isBlank() || name.isEmpty()||name.equals("null"))
                    name = null;
        Pageable page= PageRequest.of(pageNum, pageSize, Sort.by(isAsc? Direction.ASC:Direction.DESC, col));
        return employeeRepository.findByName(name,page);
    }

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<Employee> findByNameAndDeptName(String name, String departmentName) {
        return employeeRepository.findByNameContainingAndDepartment_NameContaining(name, departmentName);
    }

    public List<Employee> findByDepartmentId(long id) {
        return employeeRepository.findByDepartmentId(id);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public Long countByNameAndDeptName(String name, String departmentname) {
        return employeeRepository.countByNameContainingAndDepartment_NameContaining(name, departmentname);
    }

    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee) {
        Employee current = employeeRepository.findById(employee.getId()).get();
        current.setName(employee.getName());
        current.setSalary(employee.getSalary());
        current.setDepartment(employee.getDepartment());
        return employeeRepository.save(employee);
    }

    public Boolean deleteByNameAndDeptName(String name, String departmentname) {
        Boolean isDeleted = false;
        try {
            List<Employee> employees = employeeRepository.findByNameContainingAndDepartment_NameContaining(name,
                    departmentname);
            employeeRepository.deleteByNameContainingAndDepartment_NameContaining(name, departmentname);
            for (Employee employee : employees) {
                userService.delete(employee.getUser());
                isDeleted = true;
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return isDeleted;
    }

    public HrStatistic getHrStatistic() {
        return employeeRepository.getHRStatics();
    }

}

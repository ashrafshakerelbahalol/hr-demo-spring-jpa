package com.global.demospringjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.demospringjpa.Entity.Department;

import com.global.demospringjpa.Repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public  Optional<Department> findByIdOptional(Long id) {
        return departmentRepository.findById(id);
    }
    public  Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    public List<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    public Department update(Department department) {
         Department current= departmentRepository.findById(department.getId()).get();
         current.setName(department.getName());
         current.setNumberOfEmployee(department.getNumberOfEmployee());
         return departmentRepository.save(current);
    }

    public Department insert(Department department) {
        return departmentRepository.save(department);
    }

    public List <Department> findAll() {
            return departmentRepository.findAll();
 
    }

}

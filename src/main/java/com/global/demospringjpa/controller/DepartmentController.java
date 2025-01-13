package com.global.demospringjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.global.demospringjpa.Entity.Department;

import com.global.demospringjpa.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("findbyid/{id}")
    public Department findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }
    @GetMapping("findall")
    public List <Department> findAll() {
        return departmentService.findAll();
    }


    @GetMapping("departmentname/{name}")
    public List<Department> findByName(@PathVariable String name) {
        return departmentService.findByName(name);
    }

   @PostMapping("insert")
    public Department insert(@RequestBody Department department) {
        return departmentService.insert(department);
    }
    @PutMapping("update")
    public Department update(@RequestBody Department department) {
        
        return departmentService.update(department);
    }
}

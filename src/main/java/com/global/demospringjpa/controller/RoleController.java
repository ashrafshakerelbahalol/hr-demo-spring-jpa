package com.global.demospringjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.demospringjpa.Entity.Role;
import com.global.demospringjpa.service.RoleService;
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @GetMapping("findbyid/{id}")
    public Role findById(@PathVariable Long id) {
        return roleService.findById(id);
    }
    @GetMapping("findall")
    public List <Role> findAll() {
        return roleService.findAll();
    }
    @GetMapping("rolename/{name}")
    public List<Role> findByRole(@PathVariable String name) {
        return roleService.findByRole(name);
    }
   @PostMapping("insert")
    public Role insert(@RequestBody Role role) {
        
        return roleService.insert(role);
    }
    @PutMapping("update")
    public Role update(@RequestBody Role role) {
        
        return roleService.update(role);
    }
}



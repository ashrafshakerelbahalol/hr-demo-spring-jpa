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
import com.global.demospringjpa.Entity.User;
import com.global.demospringjpa.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("findbyid/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @GetMapping("findall")
    public List <User> findAll() {
        return userService.findAll();
    }
    @GetMapping("username/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }
   @PostMapping("insert")
    public User insert(@RequestBody User user) {
        
        return userService.insert(user);
    }
    @PutMapping("update")
    public User update(@RequestBody User user) {
        
        return userService.update(user);
    }
    @PutMapping("addroletoalluser/{name}")
    public void addRoleToAllUsers( @PathVariable String name) {
        
         userService.addRoleToAllUsers(name);
    }
}

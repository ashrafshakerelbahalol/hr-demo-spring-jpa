package com.global.demospringjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.demospringjpa.Entity.Role;
import com.global.demospringjpa.Entity.User;
import com.global.demospringjpa.Repository.UserRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findByName(String name) {
        return userRepository.findByUsername(name);
    }

    public User update(User user) {
        User current = userRepository.findById(user.getId()).get();
        current.setUsername(user.getUsername());
        current.setPassword(user.getPassword());
        return userRepository.save(current);
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();

    }

    public void delete(User user) {
        User currentUser = findById(user.getId());
        System.out.println(currentUser.getId());
        userRepository.deleteById(currentUser.getId());

    }

    @Transactional
    public void addRoleToAllUsers(String name) {
        Role currentRole = roleService.findByName(name);
        findAll().forEach(user->{
          user.addRole(currentRole);
        });
       
    }
}

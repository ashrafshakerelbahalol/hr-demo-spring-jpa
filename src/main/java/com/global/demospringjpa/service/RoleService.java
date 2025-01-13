package com.global.demospringjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.demospringjpa.Entity.Role;
import com.global.demospringjpa.Repository.RoleRepository;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }
 
    

    public Role update(Role role) {
         Role current= roleRepository.findById(role.getId()).get();
         current.setRole(role.getRole());
         return roleRepository.save(current);
    }

    public Role insert(Role role) {
        return roleRepository.save(role);
    }

    public List <Role> findAll() {
            return (List<Role>) roleRepository.findAll();
 
    }

    public List<Role> findByRole(String name) {
        return roleRepository.findByRoleRole(name);
    }
    
}

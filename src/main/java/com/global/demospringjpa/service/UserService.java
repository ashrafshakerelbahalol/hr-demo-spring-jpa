package com.global.demospringjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.demospringjpa.Entity.User;
import com.global.demospringjpa.Repository.UserRepository;

@Service
public class UserService {
@Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findByName(String name) {
        return userRepository.findByUsername(name);
    }

    public User update(User user) {
         User current= userRepository.findById(user.getId()).get();
         current.setUsername(user.getUsername());
         current.setPassword(user.getPassword());
         return userRepository.save(current);
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public List <User> findAll() {
            return (List<User>) userRepository.findAll();
 
    }
    public void delete(User user) {
        User currentUser =findById(user.getId());
        System.out.println(currentUser.getId());
        userRepository.deleteById(currentUser.getId());

}
}

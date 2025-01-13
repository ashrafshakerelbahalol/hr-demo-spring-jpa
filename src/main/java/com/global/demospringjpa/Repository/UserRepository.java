package com.global.demospringjpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.demospringjpa.Entity.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository < User, Long> {

    List<User> findByUsername(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM User e WHERE e.id = :id")
    void deleteById(Long id);

}

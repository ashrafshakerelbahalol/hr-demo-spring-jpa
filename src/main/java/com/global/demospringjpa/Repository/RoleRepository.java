package com.global.demospringjpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.global.demospringjpa.Entity.Role;

public interface RoleRepository extends JpaRepository <Role,Long> {
    @Query("Select role from Role role where name=:name")
    Role findByName(String name);

}

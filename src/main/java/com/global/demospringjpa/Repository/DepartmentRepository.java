package com.global.demospringjpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.demospringjpa.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    List<Department> findByName(String name);

    @Query(value="select emp from Department emp where emp.name = :emp_name ")
    List<Department>filterName(@Param("emp_name")String name);

    @Query(value="select * from department  where name = :emp_name; ",nativeQuery = true)
    List<Department>filterNameNative(@Param("emp_name")String name);

}

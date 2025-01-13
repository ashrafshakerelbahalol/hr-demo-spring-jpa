package com.global.demospringjpa.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.demospringjpa.Entity.Employee;
import com.global.demospringjpa.projection.EmployeeProjection;
import com.global.demospringjpa.projection.HrStatistic;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select emp.id AS id, emp.name AS nsame, emp.department.name AS departmentName from Employee emp where :emp_name is null  or emp.name = :emp_name ")
    Page<EmployeeProjection> findByName(@Param("emp_name") String name,Pageable pageable);

    
    List<EmployeeProjection> findBySalary(Double salary);
    
    @Query(value = "select emp from Employee emp  where  emp.department.id=:id")
    List<Employee> findByDepartmentId(Long id);
    //@Query(value = "select emp from Employee emp left join Department dept on emp.department.id=dept.id where dept.id=:id")
    //List<Employee> findByDepartmentId(Long id);

    @Query(value = "select emp from Employee emp where emp.name = :emp_name ")
    List<Employee> filterName(@Param("emp_name") String name);

    @Query(value = "select * from Employee  where name = :emp_name; ", nativeQuery = true)
    List<Employee> filterNameNative(@Param("emp_name") String name);

    List<Employee> findByNameContainingAndDepartment_NameContaining(String name, String deptName);

    Long countByNameContainingAndDepartment_NameContaining(String name, String departmentName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.name LIKE %:name% AND e.department.name LIKE %:departmentName%")
    int deleteByNameContainingAndDepartment_NameContaining(String name, String departmentName);
      
    @Query(value="select (select count(*)from department)deptCount"
    +",(select count(*) from employee)empCount"+
    ",(select count(*) from sec_user_role)userCount",nativeQuery = true)
    HrStatistic getHRStatics();
}

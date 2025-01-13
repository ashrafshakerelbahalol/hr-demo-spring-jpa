package com.global.demospringjpa.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "Employee.findBySalary", query = "SELECT emp FROM Employee emp WHERE salary>:salary")
@Table(name = "employee")
public class Employee {
    @Id
    // @GeneratedValue(strategy =GenerationType.SEQUENCE,generator ="employee_gen")
    // @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    // @TableGenerator(name = "employee_gen", table = "employee_gen", initialValue = 10,allocationSize = 1)
    private Long id;
    private String name;
    private Double salary;

    @ManyToOne()
    //cascade = CascadeType.ALL
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee() {
    }

    public Employee(Long id, String name,Department department  ) {
        this.id = id;
        this.name = name;
        this.department=department;
         

    }

}

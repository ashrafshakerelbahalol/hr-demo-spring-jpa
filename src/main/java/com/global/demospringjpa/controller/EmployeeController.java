package com.global.demospringjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.global.demospringjpa.Entity.Employee;
import com.global.demospringjpa.projection.EmployeeProjection;
import com.global.demospringjpa.projection.HrStatistic;
import com.global.demospringjpa.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("findbyid/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("findbynameanddeptname")
    public List<Employee> findByNameAndDeptName(@RequestParam String name, @RequestParam String departmentname) {
        return employeeService.findByNameAndDeptName(name, departmentname);
    }

    @GetMapping("countbynameanddeptname")
    public ResponseEntity<Long> countByNameAndDeptName(@RequestParam String name, @RequestParam String departmentname) {
        return ResponseEntity.ok(employeeService.countByNameAndDeptName(name, departmentname));
    }

    @GetMapping("findbysalary")
    public ResponseEntity<List<EmployeeProjection>> findBySalary(@RequestParam Double salary) {
        return ResponseEntity.ok(employeeService.findBySalary(salary));
    }

    @GetMapping("findall")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("findbyname")
    public ResponseEntity<?> findByName(@RequestParam String name,@RequestParam boolean isAsc,
    @RequestParam String col,
    @RequestParam int pageNum,
    @RequestParam int pageSize) {
                return  ResponseEntity.ok( employeeService.findByName(name,isAsc,col, pageNum, pageSize));
    }

    @GetMapping("findbydepartmentid/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id) {
        return employeeService.findByDepartmentId(id);
    }
    @GetMapping("gethrstatistic")
    public ResponseEntity<HrStatistic> getHrStatistic() {
        return ResponseEntity.ok(employeeService.getHrStatistic());
    }
    

    @DeleteMapping("deletebynameanddeptname")
    public ResponseEntity<Boolean> deleteByNameAndDeptName(@RequestParam String name,
            @RequestParam String departmentname) {
        return ResponseEntity.ok(employeeService.deleteByNameAndDeptName(name, departmentname));
    }

    @PostMapping("insert")
    public Employee insert(@RequestBody Employee employee) {
        return employeeService.insert(employee);
    }

    @PutMapping("update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }


    

}

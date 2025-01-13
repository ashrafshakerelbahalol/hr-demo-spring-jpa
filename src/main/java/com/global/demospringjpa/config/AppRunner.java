package com.global.demospringjpa.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.demospringjpa.Entity.Department;
import com.global.demospringjpa.Entity.Employee;
import com.global.demospringjpa.Entity.Role;
import com.global.demospringjpa.Entity.User;
import com.global.demospringjpa.Repository.EmployeeRepository;
import com.global.demospringjpa.service.DepartmentService;
import com.global.demospringjpa.service.EmployeeService;
import com.global.demospringjpa.service.RoleService;
import com.global.demospringjpa.service.UserService;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void run(String... args) throws Exception {
        if (departmentService.findAll().isEmpty() && employeeService.findAll().isEmpty()) {
            Role role1 = new Role();
            role1.setRole("admin");
            roleService.insert(role1);
            Role role2 = new Role();
            role2.setRole("gogo");
            roleService.insert(role2);
            Role role3 = new Role();
            role3.setRole("user");
            roleService.insert(role3);

            Set<Role> roles = new HashSet<>();
            roles.add(role3);
            roles.add(role2);

            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword("password");
            user1.setRoles(roles);
      
            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword("pas2rd");
            user2.setRoles(roles);

            User user3 = new User();
            user3.setUsername("user3");
            user3.setPassword("pas3rd");
            user3.setRoles(roles);

            User user4 = new User();
            user4.setUsername("user4");
            user4.setPassword("pas4rd");
            user4.setRoles(roles);
        
      

            Department department = new Department();
            department.setId(1L);
            department.setName("accountant");
            departmentService.insert(department);

            Employee employee1 = new Employee();
            employee1.setName("ashraf");
            employee1.setSalary(452.25d);
            employee1.setUser(user1);
            employee1.setDepartment(department);
            employeeService.insert(employee1);

            Employee employee2 = new Employee();
            employee2.setName("youssef");
            employee2.setSalary(9552.25d);
            employee2.setUser(user2);
            employee2.setDepartment(department);
            employeeService.insert(employee2);

            Employee employee3 = new Employee();
            employee3.setName("ashraf mostafa");
            employee3.setSalary(34541.25d);
            employee3.setUser(user3);
            employee3.setDepartment(department);
            employeeService.insert(employee3);

            Employee employee4 = new Employee();
            employee4.setName("youssef shaker");
            employee4.setSalary(1051452.25d);
            employee4.setUser(user4);
            employee4.setDepartment(department);
            employeeService.insert(employee4);
            
            for (int i = 5; i <= 300; i++) {
                // Create a unique set of roles for each user
                Set<Role> role = new HashSet<>();
                role.add(role3); // Assign "user" role by default
                if (i % 2 == 0) {
                    role.add(role2); // Assign "gogo" role for even-numbered users
                }
                if (i % 3 == 0) {
                    role.add(role1); // Assign "admin" role for users divisible by 3
                }
            
                // Create a new user
                User user = new User();
                user.setUsername("user" + i); // Unique username
                user.setPassword("password" + i); // Unique password
                user.setRoles(role);
            
            
            
                // Create a new employee
                Employee employee = new Employee();
                employee.setName("Employee " + i); // Unique name
                employee.setSalary(1000.0 * i); // Unique salary
                employee.setUser(user); // Assign the persisted user
                employee.setDepartment(department);
            
                // Save the employee
                employeeService.insert(employee);
            }
        }
    }

}

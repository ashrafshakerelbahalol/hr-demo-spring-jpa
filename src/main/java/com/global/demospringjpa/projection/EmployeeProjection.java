package com.global.demospringjpa.projection;

import org.springframework.beans.factory.annotation.Value;

import com.global.demospringjpa.Entity.Department;

public interface EmployeeProjection {
    Long getId();
    @Value("#{target.nsame}")
    String getNsame();
    String getDepartmentName();
}

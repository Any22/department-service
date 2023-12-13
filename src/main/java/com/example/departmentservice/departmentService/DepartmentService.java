package com.example.departmentservice.departmentService;

import org.springframework.stereotype.Service;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;
@Service
public interface DepartmentService {
	
	Department saveDepartment (Department department);
	DepartmentDTO getDepartmentById (Long departmentId);
	

}

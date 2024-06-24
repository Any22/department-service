package com.example.departmentservice.departmentService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;
@Service
public interface DepartmentService {
	
	void saveDepartment (DepartmentDTO departmentDTO);
	DepartmentDTO getDepartmentById (Long departmentId);
	List<DepartmentDTO> getAllDepartments();// to be implemnted after coming back 
	

}

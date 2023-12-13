package com.example.departmentservice.departmentService;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	@Autowired
    private ModelMapper modelMapper;  

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);

	}

	@Override
	public DepartmentDTO getDepartmentById(Long departmentId){
		
		 Optional<Department> deptOptional = departmentRepository.findById(departmentId);
		 
		 if (deptOptional.isPresent()) {
		    	
		    	Department department = deptOptional.get();
		    
		    	 return modelMapper.map(department, DepartmentDTO.class);	
		      
		    }  
		
		return new DepartmentDTO();

	}

	

}

package com.example.departmentservice.departmentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
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

	@Override
	public List<DepartmentDTO> getAllDepartments() {
       List<Department>  department = departmentRepository.findAll();
		
		if (department.isEmpty()) {
			LOGGER.error("there is no data");
		}
		List<DepartmentDTO> departmentDTO = department.stream()
				.map(eachUser -> modelMapper.map(eachUser,DepartmentDTO.class ))
				.collect(Collectors.toList());
		
		return departmentDTO;
	}

	

}

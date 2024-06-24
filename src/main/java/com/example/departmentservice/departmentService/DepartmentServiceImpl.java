package com.example.departmentservice.departmentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservice.departmentController.DepartmentController;
import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	@Autowired
    private ModelMapper modelMapper;  

	@Override
	public void saveDepartment(DepartmentDTO departmentDTO) {
		
		Department department = Department.builder()
				.deptId(departmentDTO.getId())
				.departmentName(departmentDTO.getDepartmentName())
				.departmentAddress(departmentDTO.getDepartmentAddress())
				.departmentCode(departmentDTO.getDepartmentCode())
				.build();
		
		departmentRepository.save(department);

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
			log.error("No data found");
		}
		
		List<DepartmentDTO> departmentDTO = department.stream()
				.map(eachUser -> modelMapper.map(eachUser,DepartmentDTO.class ))
				.collect(Collectors.toList());
		
		return departmentDTO;
	}

	

}

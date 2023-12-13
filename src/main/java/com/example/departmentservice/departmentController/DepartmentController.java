package com.example.departmentservice.departmentController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.departmentService.DepartmentService;
import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;

import lombok.AllArgsConstructor;
/*********************************************************************************************************************************************
 * this microservice is a cient for config server 
 * we have added the config Client starter dependency in pom.xml 
 *
 *
 ********************************************************************************************************************************************/
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
	@Autowired 
	private DepartmentService departmentService;
	
	private static final Log LOGGER=LogFactory.getLog(DepartmentController.class) ;
	
	@PostMapping
	public ResponseEntity<Department> saveDepartment (@RequestBody Department department){
		Department savedDepartment = departmentService.saveDepartment(department);
		
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
		
	}
	
///i was getting error not found and the reason behind that I forgot to put currly braces for deptId
	@GetMapping("{deptId}")
	public ResponseEntity<DepartmentDTO> getDepartmentById (@PathVariable Long deptId) throws Exception {
		 LOGGER.info("department id "+ deptId);
	        DepartmentDTO departmentDto = departmentService.getDepartmentById(deptId);
	        
	        if (departmentDto != null) {
	            // Convert entity to DTO
	           
	            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	
	
	
	}




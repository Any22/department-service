package com.example.departmentservice.departmentController;

import java.util.List;

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
import lombok.extern.slf4j.Slf4j;

 /*************************************************************************************************************************************
 * This microservice is a client for config server 
 * we have added the config Client starter dependency in pom.xml 
 *
 *
 **************************************************************************************************************************************/
@RestController
@Slf4j
@RequestMapping("api/v1/departments")
public class DepartmentController {
	
	@Autowired 
	private DepartmentService departmentService;
	
/**************************************************************************************************************************************
 * Adds a new department related data
 * @param department
 * @return ReponseEntity of type Department with HttpStatus "created"
 *************************************************************************************************************************************/
	@PostMapping(value="/add")
	public ResponseEntity<?> addDepartment (@RequestBody DepartmentDTO departmentDTO){
		
		log.info("The department data to be added {}", departmentDTO);
		departmentService.saveDepartment(departmentDTO);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
/**************************************************************************************************************************************
 * Gets all departments and extended data 
 * @param department
 * @return ReponseEntity of type Department with HttpStatus "created"
***************************************************************************************************************************************/
	@GetMapping(value="/get")
	public ResponseEntity<List<DepartmentDTO>> getAllDepartments (){
		
		List<DepartmentDTO> departmentDTOs = departmentService.getAllDepartments();
		log.info("The List of all departments {}", departmentDTOs);
		
		return new ResponseEntity<>(departmentDTOs, HttpStatus.OK);
		
	}
	
    ///I was getting error "not found" and the cause was I forgot to put currly braces for deptId
	@GetMapping("/get/{deptId}")
	public ResponseEntity<DepartmentDTO> getDepartmentById (@PathVariable Long deptId) throws Exception {
		
		 log.info("department id "+ deptId);
	        DepartmentDTO departmentDto = departmentService.getDepartmentById(deptId);
	        
	        if (departmentDto != null) {
	            // Convert entity to DTO
	           
	            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	
	
	
	}




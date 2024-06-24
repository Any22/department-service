package com.example.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
	
	private Long id;
	
	private String departmentName;
	
	private String departmentAddress;
	
	private String departmentCode;

}

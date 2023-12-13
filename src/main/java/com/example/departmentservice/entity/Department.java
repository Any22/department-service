package com.example.departmentservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="department")

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_dept_id_seq")
	@SequenceGenerator(name = "department_dept_id_seq", sequenceName = "department_dept_id_seq", allocationSize = 1)
	@Column(name="dept_id")
	private Long deptId;
	@Column(name="department_name")
	private String departmentName;
	@Column(name="department_address")
	private String departmentAddress;
	@Column(name="department_code")
	private String departmentCode;
	public Department() {
		
	}
	public Department(Long deptId, String departmentName, String departmentAddress, String departmentCode) {
		super();
		this.deptId = deptId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	
}

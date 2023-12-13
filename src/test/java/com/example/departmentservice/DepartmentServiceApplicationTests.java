package com.example.departmentservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.departmentservice.testconfiguration.TestConfig;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class DepartmentServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

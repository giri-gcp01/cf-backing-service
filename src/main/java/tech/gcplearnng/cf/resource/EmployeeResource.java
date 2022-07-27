package tech.gcplearnng.cf.resource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.gcplearnng.cf.domain.Employee;
import tech.gcplearnng.cf.repository.EmployeeRepository;

@RestController
public class EmployeeResource {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		
		return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
				

	}

}

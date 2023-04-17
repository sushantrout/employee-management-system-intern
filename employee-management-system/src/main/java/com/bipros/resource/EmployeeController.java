package com.bipros.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bipros.entity.Employee;
import com.bipros.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	// Create
	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	// Read
	@GetMapping
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return employeeService.getById(id);
	}

	// Update
	@PutMapping("/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return employeeService.update(employee);
	}

	// Delete
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		employeeService.deleteById(id);
	}

}

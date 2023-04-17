package com.bipros.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipros.entity.Employee;
import com.bipros.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	// Create
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	// Read
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee getById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));
	}

	// Update
	public Employee update(Employee employee) {
		Employee existingEmployee = employeeRepository.findById(employee.getId())
				.orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + employee.getId()));

		existingEmployee.setFullName(employee.getFullName());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setSalary(employee.getSalary());

		return employeeRepository.save(existingEmployee);
	}

	// Delete
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

}

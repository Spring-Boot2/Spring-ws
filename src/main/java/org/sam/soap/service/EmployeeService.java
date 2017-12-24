package org.sam.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.sam.soap.entity.Employee;
import org.sam.soap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sumit
 *
 */
@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public synchronized boolean addEmployee(Employee employee) {
		List<Employee> list = employeeRepository.findByFirstnameAndLastname(employee.getFirstname(),employee.getLastname());
		if (list.size() > 0) {
			return false;
		} else {
			employeeRepository.save(employee);
			return true;
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
}

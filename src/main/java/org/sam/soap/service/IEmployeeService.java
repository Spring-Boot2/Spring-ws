package org.sam.soap.service;

import java.util.List;
import org.sam.soap.entity.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long employeeId);

	boolean addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(Employee employee);
}

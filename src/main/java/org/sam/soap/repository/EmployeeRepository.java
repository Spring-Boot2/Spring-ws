package org.sam.soap.repository;

import java.util.List;

import org.sam.soap.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sumit
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Employee findByEmployeeId(Long employeeId);
	
	List<Employee> findByFirstnameAndLastname(String firstname, String lastname);
	
	
}

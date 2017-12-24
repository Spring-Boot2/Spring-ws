package org.sam.soap.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.sam.soap.entity.Employee;
import org.sam.soap.gs_ws.AddEmployeeRequest;
import org.sam.soap.gs_ws.AddEmployeeResponse;
import org.sam.soap.gs_ws.DeleteEmployeeRequest;
import org.sam.soap.gs_ws.DeleteEmployeeResponse;
import org.sam.soap.gs_ws.EmployeeInfo;
import org.sam.soap.gs_ws.GetAllEmployeesResponse;
import org.sam.soap.gs_ws.GetEmployeeByIdRequest;
import org.sam.soap.gs_ws.GetEmployeeByIdResponse;
import org.sam.soap.gs_ws.ServiceStatus;
import org.sam.soap.gs_ws.UpdateEmployeeRequest;
import org.sam.soap.gs_ws.UpdateEmployeeResponse;
import org.sam.soap.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://www.concretepage.com/employee-ws";
	@Autowired
	private IEmployeeService employeeService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeByIdResponse getArticle(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
	@ResponsePayload
	public GetAllEmployeesResponse getAllEmployees() {
		GetAllEmployeesResponse response = new GetAllEmployeesResponse();
		List<EmployeeInfo> employeeInfoList = new ArrayList<>();
		List<Employee> employeeList = employeeService.getAllEmployees();
		for (int i = 0; i < employeeList.size(); i++) {
			EmployeeInfo ob = new EmployeeInfo();
			BeanUtils.copyProperties(employeeList.get(i), ob);
			employeeInfoList.add(ob);
		}
		response.getEmployeeInfo().addAll(employeeInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addArticle(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Employee employee = new Employee();
		employee.setFirstname(request.getFirstname());
		employee.setLastname(request.getLastname());
		boolean flag = employeeService.addEmployee(employee);
		if (flag == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Content Already Available");
			response.setServiceStatus(serviceStatus);
		} else {
			EmployeeInfo employeeInfo = new EmployeeInfo();
			BeanUtils.copyProperties(employee, employeeInfo);
			response.setEmployeeInfo(employeeInfo);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
			response.setServiceStatus(serviceStatus);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateArticle(@RequestPayload UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.updateEmployee(employee);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteArticle(@RequestPayload DeleteEmployeeRequest request) {
		Employee employee = employeeService.getEmployeeById(request.getEmployeeId());
		ServiceStatus serviceStatus = new ServiceStatus();
		if (employee == null) {
			serviceStatus.setStatusCode("FAIL");
			serviceStatus.setMessage("Content Not Available");
		} else {
			employeeService.deleteEmployee(employee);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Deleted Successfully");
		}
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}
}

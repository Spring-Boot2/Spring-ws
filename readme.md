# Spring WS With Spring Boot And Spring Data JPA / Basic CRUD Operation Using SOAP

* Get All Employees
* URL : http://localhost:8888/SpringSoapWS/employees.wsdl
* METHOD : POST
* REQUEST PALOAD --
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:emp="http://www.concretepage.com/employee-ws">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:getAllEmployeesRequest/>
   </soapenv:Body>
 </soapenv:Envelope> 
 ```
 RESPONSE Response --
 ```xml
 <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getAllEmployeesResponse xmlns:ns2="http://www.concretepage.com/employee-ws">
            <ns2:employeeInfo>
                <ns2:employeeId>1</ns2:employeeId>
                <ns2:firstname>Jagadish</ns2:firstname>
                <ns2:lastname>Samaddar</ns2:lastname>
            </ns2:employeeInfo>
            <ns2:employeeInfo>
                <ns2:employeeId>2</ns2:employeeId>
                <ns2:firstname>LilaBati</ns2:firstname>
                <ns2:lastname>Samaddar</ns2:lastname>
            </ns2:employeeInfo>
            <ns2:employeeInfo>
                <ns2:employeeId>3</ns2:employeeId>
                <ns2:firstname>Sumit</ns2:firstname>
                <ns2:lastname>Samaddar</ns2:lastname>
            </ns2:employeeInfo>
            <ns2:employeeInfo>
                <ns2:employeeId>4</ns2:employeeId>
                <ns2:firstname>Sneha</ns2:firstname>
                <ns2:lastname>Samaddar</ns2:lastname>
            </ns2:employeeInfo>
            <ns2:employeeInfo>
                <ns2:employeeId>5</ns2:employeeId>
                <ns2:firstname>Arna</ns2:firstname>
                <ns2:lastname>Samaddar</ns2:lastname>
            </ns2:employeeInfo>
        </ns2:getAllEmployeesResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
 ```
* Get Employee By Id
* URL : http://localhost:8888/SpringSoapWS/employees.wsdl
* METHOD : POST
* REQUEST PALOAD --
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
 xmlns:emp="http://www.concretepage.com/employee-ws">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:getEmployeeByIdRequest>
         <emp:employeeId>2</emp:employeeId>
      </emp:getEmployeeByIdRequest>
   </soapenv:Body>
 </soapenv:Envelope>  
 ```
 RESPONSE Response --
 ```xml
 <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getEmployeeByIdResponse xmlns:ns2="http://www.concretepage.com/employee-ws">
            <ns2:employeeInfo>
                <ns2:employeeId>2</ns2:employeeId>
                <ns2:firstname>LilaBati</ns2:firstname>
                <ns2:lastname>Samaddar</ns2:lastname>
            </ns2:employeeInfo>
        </ns2:getEmployeeByIdResponse>
    </SOAP-ENV:Body>
 </SOAP-ENV:Envelope>
 ```
* Add New Employee
* URL : http://localhost:8888/SpringSoapWS/employees.wsdl
* METHOD : POST
* REQUEST PALOAD --
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
 xmlns:emp="http://www.concretepage.com/employee-ws">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:addEmployeeRequest>
         <emp:firstname>Sumita jdh kjsdhfksdjhfjk</emp:firstname>
         <emp:lastname>Samaddar</emp:lastname>
      </emp:addEmployeeRequest>
   </soapenv:Body>
 </soapenv:Envelope>   
 ```
 RESPONSE Response --
 ```xml
 <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:addEmployeeResponse xmlns:ns2="http://www.concretepage.com/employee-ws">
            <ns2:serviceStatus>
                <ns2:statusCode>SUCCESS</ns2:statusCode>
                <ns2:message>Content Added Successfully</ns2:message>
            </ns2:serviceStatus>
            <ns2:employeeInfo>
                <ns2:employeeId>6</ns2:employeeId>
                <ns2:firstname>Samaddar</ns2:firstname>
            </ns2:employeeInfo>
        </ns2:addEmployeeResponse>
    </SOAP-ENV:Body>
 </SOAP-ENV:Envelope>
 ```
* Update Employee
* URL : http://localhost:8888/SpringSoapWS/employees.wsdl
* METHOD : POST
* REQUEST PALOAD --
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
 xmlns:emp="http://www.concretepage.com/employee-ws">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:updateEmployeeRequest>
      	<emp:employeeInfo>
  			<emp:employeeId>6</emp:employeeId>
	        <emp:firstname>Sumita 1</emp:firstname>
	        <emp:lastname>Samaddar 2</emp:lastname>
      	</emp:employeeInfo>
      </emp:updateEmployeeRequest>
   </soapenv:Body>
 </soapenv:Envelope>   
 ```
 RESPONSE Response --
 ```xml
 <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:updateEmployeeResponse xmlns:ns2="http://www.concretepage.com/employee-ws">
            <ns2:serviceStatus>
                <ns2:statusCode>SUCCESS</ns2:statusCode>
                <ns2:message>Content Updated Successfully</ns2:message>
            </ns2:serviceStatus>
        </ns2:updateEmployeeResponse>
    </SOAP-ENV:Body>
 </SOAP-ENV:Envelope>
 ```
* Delete Employee
* URL : http://localhost:8888/SpringSoapWS/employees.wsdl
* METHOD : POST
* REQUEST PALOAD --
 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
 xmlns:emp="http://www.concretepage.com/employee-ws">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:deleteEmployeeRequest>
  		<emp:employeeId>6</emp:employeeId>
	  </emp:deleteEmployeeRequest>
   </soapenv:Body>
 </soapenv:Envelope> 
 ```
 RESPONSE Response --
 ```xml
 <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:deleteEmployeeResponse xmlns:ns2="http://www.concretepage.com/employee-ws">
            <ns2:serviceStatus>
                <ns2:statusCode>SUCCESS</ns2:statusCode>
                <ns2:message>Content Deleted Successfully</ns2:message>
            </ns2:serviceStatus>
        </ns2:deleteEmployeeResponse>
    </SOAP-ENV:Body>
 </SOAP-ENV:Envelope>
 ```

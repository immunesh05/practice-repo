package com.demobiggrin.Practice.controller;

import com.demobiggrin.Practice.entities.Employee;
import com.demobiggrin.Practice.repository.EmployeeRepository;
import com.demobiggrin.Practice.requests.EmployeeRequest;
import com.demobiggrin.Practice.response.BaseResponse;
import com.demobiggrin.Practice.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest employeeRequest){
        Employee employee = mapEmployeeRequestToEmployee(employeeRequest);
        employee = employeeRepository.save(employee);
        EmployeeResponse studentResponse = mapEmployeeRequestToEmployeeResponse(employee);
        return studentResponse;
    }

    private Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setAddress(employeeRequest.getAddress());
        employee.setName(employeeRequest.getName());
        employee.setDepartment(employeeRequest.getDepartment());
        return employee;
    }

    private EmployeeResponse mapEmployeeRequestToEmployeeResponse(Employee employee){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setAddress(employee.getAddress());
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setCode(HttpStatus.CREATED.value());
        employeeResponse.setStatus(HttpStatus.CREATED.name());
        return employeeResponse;
    }

    @GetMapping("/get")
    public EmployeeResponse getEmployee(@RequestParam int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeResponse employeeResponse = mapEmployeeRequestToEmployeeResponse(employee.get());
        return employeeResponse;
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @PutMapping("/update")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest employeeRequest) throws Exception {
        EmployeeResponse employeeResponse =null;
        if(employeeRequest.getId()!=null){
            Employee employee= employeeRepository.findById(employeeRequest.getId()).get();

            if(employee==null){
                throw new Exception(HttpStatus.BAD_REQUEST.name());
            }else{
                updateEmployeeRequestToEmployee(employeeRequest,employee);
                employeeRepository.save(employee);
                employeeResponse = mapEmployeeRequestToEmployeeResponse(employee);
            }

        }
        return employeeResponse;
    }

    private void updateEmployeeRequestToEmployee(EmployeeRequest employeeRequest, Employee employee){
        if(employeeRequest.getName()!=null){
            employee.setName(employeeRequest.getName());
        }
        if(employeeRequest.getDepartment()!=null){
            employee.setDepartment(employeeRequest.getDepartment());
        }
        if(employeeRequest.getAddress()!=null){
            employee.setAddress(employeeRequest.getAddress());
        }
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteEmployee(@RequestParam int id) {
        employeeRepository.deleteById(id);
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatus(HttpStatus.OK.name());
        baseResponse.setCode(HttpStatus.OK.value());
        return baseResponse;
    }
}

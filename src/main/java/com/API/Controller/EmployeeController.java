package com.API.Controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import javax.management.AttributeNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.API.DemoApplication;
import com.API.Service.EmployeeService;
import com.API.dto.EmployeeDTO;
import com.API.errors.ResourceNotFoundException;
import com.API.integrations.EmployeeRepository;
import com.API.model.Employee;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController implements ErrorController {
    @Autowired
    private EmployeeService employeeService;
    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

    
    private final static String PATH = "/error";
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "No Mapping Found";
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
    	LOGGER.info("This is info message");
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/employees/{id}")
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
    	EmployeeDTO dto = employeeService.getEmployeeByID(id);
    	return ResponseEntity.ok().body(dto);
    }
    
    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO dto) {
    	return employeeService.createEmployee(dto);
    }
    
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deletEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
    

}
package com.API.integrations;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.API.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}

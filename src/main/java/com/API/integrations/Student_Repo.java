package com.API.integrations;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.API.model.Students;

@Repository
public interface Student_Repo extends CrudRepository<Students, Long>{

}

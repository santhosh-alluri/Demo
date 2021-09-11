package com.API.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.integrations.Student_Repo;
import com.API.model.Students;

@Service
public class Student_Service {
	
	@Autowired
	Student_Repo student_repo;
	
	
	
	public Students getStudentByID(long ID) {
		Optional<Students> dao = student_repo.findById(ID);
		Students dao1=dao.orElse(null);
		return dao1;
	}
	

}

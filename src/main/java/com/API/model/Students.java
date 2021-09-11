package com.API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
	
	private String studentName;
	private int studentID;
	private long ID;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}

}

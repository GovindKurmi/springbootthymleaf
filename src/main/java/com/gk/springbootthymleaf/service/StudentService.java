package com.gk.springbootthymleaf.service;

import com.gk.springbootthymleaf.model.Student;

public interface StudentService {

	public Student getStudent(String rollno);

	public void saveStudent(Student student);


}

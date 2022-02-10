package com.gk.springbootthymleaf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.springbootthymleaf.dao.StudentDao;
import com.gk.springbootthymleaf.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public Student getStudent(String id) {
		int rollno = Integer.parseInt(id);
		Optional<Student> studentlist = studentDao.findById(rollno);
		Student student = studentlist.get();
		return student;
	}

	@Override
	public void saveStudent(Student student) {
		studentDao.save(student);
	}

}

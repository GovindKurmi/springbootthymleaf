package com.gk.springbootthymleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.springbootthymleaf.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}

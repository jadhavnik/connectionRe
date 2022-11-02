package com.sts.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.springrest.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}

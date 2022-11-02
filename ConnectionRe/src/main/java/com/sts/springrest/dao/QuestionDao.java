package com.sts.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sts.springrest.entities.Question;

public interface QuestionDao  extends JpaRepository<Question, Long>{
}

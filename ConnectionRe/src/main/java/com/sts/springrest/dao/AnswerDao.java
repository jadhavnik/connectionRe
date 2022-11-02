package com.sts.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.springrest.entities.Answer;

public interface AnswerDao  extends JpaRepository<Answer,Long>{

}

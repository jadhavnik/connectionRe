package com.sts.springrest.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.springrest.dao.QuestionDao;
import com.sts.springrest.entities.Question;
import com.sts.springrest.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	
	@Autowired
	private QuestionDao questionDao;
	
	
	List<Question> list;
	
	@Override
	public List<Question> getQuestions() {
		// TODO Auto-generated method stub
		list = questionDao.findAll();
		return list;
	}

	@Override
	public Question getQuestion(long questionId) {
		Optional<Question> cc = questionDao.findById(questionId);
		
		return cc.get() ;
	}

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
		return question;
	}

	@Override
	public void deleteQuestion(long questionId) {
		questionDao.deleteById(questionId);
		
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
		return question;
	}

}

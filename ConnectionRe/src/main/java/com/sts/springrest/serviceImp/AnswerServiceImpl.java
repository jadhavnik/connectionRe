package com.sts.springrest.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.springrest.dao.AnswerDao;
import com.sts.springrest.entities.Answer;
import com.sts.springrest.services.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;

	List<Answer> list;

	@Override
	public List<Answer> getAnswers() {
		list = answerDao.findAll();
		return list;
	}

	@Override
	public Answer getAnswer(long answerId) {
		Optional<Answer> cc = answerDao.findById(answerId);

		return cc.get();
	}

	@Override
	public Answer addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		answerDao.save(answer);
		return answer;
	}

	@Override
	public void deleteAnswer(long answerId) {
		answerDao.deleteById(answerId);

	}

	@Override
	public Answer updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		answerDao.save(answer);
		return answer;
	}

}

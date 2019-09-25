package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
@Transactional

public interface QuestionAnswersRepository <QuestionAnswers> extends CrudRepository<QuestionAnswers, Long>{
	
	public List<QuestionAnswers> findAll();

}

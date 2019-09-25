package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.TestQuestion;

@Repository
@Transactional
public interface TestQuestionRepository extends CrudRepository<TestQuestion, Long> {
	
}
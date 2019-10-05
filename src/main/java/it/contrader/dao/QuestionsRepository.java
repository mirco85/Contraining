package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Questions;


@Repository
@Transactional
public interface QuestionsRepository extends CrudRepository<Questions, Long>{

	@Query("SELECT q FROM Questions q WHERE idtest is NULL")
	List<Questions> getAllAvailable();
}


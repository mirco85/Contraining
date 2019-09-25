package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.UserAnswers;

@Repository
@Transactional

public interface UserAnswerRepository extends CrudRepository<UserAnswers,Long> {

}

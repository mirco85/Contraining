package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
@Transactional

public interface QuestionsRepository<Questions> extends CrudRepository<Questions, Long>{
	
	public List<Questions> findAll();

}

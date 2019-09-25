package it.contrader.dao;


import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Test;

@Repository
@Transactional
public interface TestRepository extends CrudRepository<Test, Long> {
	
}
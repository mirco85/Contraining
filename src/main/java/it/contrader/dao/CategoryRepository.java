package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Category;
import it.contrader.model.User;

@Repository
@Transactional

public interface CategoryRepository extends CrudRepository<Category, Long>{

	User findByCategory(String category); 

}

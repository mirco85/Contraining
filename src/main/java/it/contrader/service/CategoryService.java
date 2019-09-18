package it.contrader.service;

import java.util.List;

import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryDAO;
import it.contrader.dto.CategoryDTO;



public class CategoryService {
	
	
	private CategoryConverter  categoryConverter;
	
	private CategoryDAO      categoryDAO;

	public CategoryService() {
		super();
		this.categoryConverter =  new CategoryConverter();
		this.categoryDAO = new CategoryDAO();
	}
	
	public List<CategoryDTO> getAll() {
		return this.categoryConverter.toDTOList(this.categoryDAO.getAll());
	}
	
	public CategoryDTO read(int id) {
		return this.categoryConverter.toDTO(this.categoryDAO.read(id));
	}

	public boolean delete(int categoryId) {
		return categoryDAO.delete(categoryId);
	}
	
	public boolean insert(CategoryDTO categoryDTO) {
		return categoryDAO.insert(categoryConverter.toEntity(categoryDTO));
	}
	
	public boolean update(CategoryDTO categoryDTO) {
		return categoryDAO.update(categoryConverter.toEntity(categoryDTO));
	}
	
}

package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CategoryDTO;

import it.contrader.model.Category;



public class CategoryConverter {
	
	public CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		if (category != null) {
			categoryDTO.setId(category.getId());
			categoryDTO.setArgument(category.getArgument());
			
		}
		return categoryDTO;
	}
	
	
	public Category toEntity(CategoryDTO categoryDTO) {
		Category category = new Category();
		if (categoryDTO != null) {
			category.setId(categoryDTO.getId());
			category.setArgument(categoryDTO.getArgument());
			
		}
		return category;
	}
	
	public List<CategoryDTO> toDTOList(List<Category> categoryList) {
		//Crea una lista vuota.
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Category category : categoryList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			categoryDTOList.add(toDTO(category));
		}
		return categoryDTOList;
	}
	
	

}

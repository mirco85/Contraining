package it.contrader.converter;

import it.contrader.dto.CategoryDTO;

import it.contrader.model.Category;


public class CategoryConverter  extends AbstractConverter<Category,CategoryDTO> {
	@Override
	public Category toEntity(CategoryDTO categoryDTO) {
		Category category = null;
		if (categoryDTO != null) {
			category = new Category(categoryDTO.getId(),categoryDTO.getCategory());			
		}
		return category;
}

	@Override
	public CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = null;
		if (category != null) {
			categoryDTO = new CategoryDTO(category.getId(),category.getCategory());
			
		}
		return categoryDTO;
	}
}
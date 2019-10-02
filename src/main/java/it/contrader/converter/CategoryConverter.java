package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CategoryDTO;

import it.contrader.model.Category;

@Component
public class CategoryConverter  extends AbstractConverter<Category,CategoryDTO> {
	@Override
	public Category toEntity(CategoryDTO categoryDTO) {
		Category category = null;
		if (categoryDTO != null) {
			System.out.println(categoryDTO.toString());
			category = new Category(categoryDTO.getId(),categoryDTO.getCategory());			
		} else {
			System.out.print("AAAAAAHHH");
		}
		return category;
}

	@Override
	public CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = null;
		if (category != null) {
			System.out.println(category.toString());
			categoryDTO = new CategoryDTO(category.getId(),category.getCategory());
			
		}
		return categoryDTO;
	}
}
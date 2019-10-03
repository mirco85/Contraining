package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.TestDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Category;
import it.contrader.model.Test;
import it.contrader.model.User;

@Component
public class TestConverter extends AbstractConverter <Test,TestDTO> {

	private static CategoryConverter categoryConverter = new CategoryConverter();
	
	@Override
	public Test toEntity(TestDTO dto) {
		// Creazione dell'oggetto test
		Test test = new Test();
		if(dto == null)
			return null;
		
		// Inserisco i dati che ho nel TestDTO nel nuovo oggetto Test 
		test.setId(dto.getId());
		
		Category c = categoryConverter.toEntity(dto.getCategory());
		test.setCategory(c);
		test.setTestName(dto.getTestName());
		test.setTimeTest(dto.getTimeTest());
		return test;
		
	}

	@Override
	public TestDTO toDTO(Test entity) {
		// Creazione dell'oggetto test
				TestDTO test = new TestDTO();
				if(entity == null)
					return null;
				
				test.setId(entity.getId());
				CategoryDTO cDto = categoryConverter.toDTO(entity.getCategory());
				
				test.setCategory(cDto);
				test.setTestName(entity.getTestName());
				test.setTimeTest(entity.getTimeTest());
		
		return test;
	}
	
	

}

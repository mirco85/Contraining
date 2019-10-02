package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TestDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Test;
import it.contrader.model.User;

@Component
public class TestConverter extends AbstractConverter <Test,TestDTO> {

	@Override
	public Test toEntity(TestDTO dto) {
		/*
		 * 1) CREO UN OGGETTO test
		 * 2) Inserisco i dati che ho nel TestDTO nel nuovo oggetto Test
		 * 3) ritorno Test
		 */
		// Creazione dell'oggetto test
		Test test = new Test();
		if(dto == null)
			return null;
		
		// Inserisco i dati che ho nel TestDTO nel nuovo oggetto Test 
		test.setId(dto.getId());
		test.setIdCategory(dto.getIdCategory());
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
				test.setIdCategory(entity.getIdCategory());
				test.setTestName(entity.getTestName());
				test.setTimeTest(entity.getTimeTest());
		
		return test;
	}
	
	

}

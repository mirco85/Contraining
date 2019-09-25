package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.model.Test;
import it.contrader.dto.TestDTO;


@Component
public class TestConverter extends AbstractConverter<Test, TestDTO> {
	@Override
	public Test toEntity(TestDTO testDTO) {
		Test test = null;
		if (testDTO != null) {
			test = new Test(testDTO.getId(), testDTO.getIdCategory(), testDTO.getTimeTest());
		}
		return test;
	}

	@Override
	public TestDTO toDTO(Test test) {
		TestDTO testDTO = null;
		if (test != null) {
			testDTO = new TestDTO(test.getId(), test.getIdCategory(), test.getTimeTest());

		}
		return testDTO;
	}
}
package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TestDTO;
import it.contrader.dto.UserAnswersDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Test;
import it.contrader.model.User;
import it.contrader.model.UserAnswers;

@Component
public class UserAnswersConverter extends AbstractConverter<UserAnswers, UserAnswersDTO>{
	
	private static UserConverter userConverter = new UserConverter();
	private static TestConverter testConverter = new TestConverter();
	
	@Override
	public UserAnswers toEntity(UserAnswersDTO useranswerdto) {
		UserAnswers useranswer = null;
		if (useranswerdto != null) {
			User u = userConverter.toEntity(useranswerdto.getUser());
			Test test =testConverter.toEntity(useranswerdto.getTest());
			useranswer = new UserAnswers(useranswerdto.getId(), useranswerdto.getIdanswer(), useranswerdto.getIdtest(),useranswerdto.getIduser(),useranswerdto.getNumtest(), u,test);
		}
		return useranswer;
	}

	@Override
	public UserAnswersDTO toDTO(UserAnswers useranswer) {
		UserAnswersDTO useranswerdto = null;
		if (useranswer != null) {
			UserDTO uDto = userConverter.toDTO(useranswer.getUser());
			TestDTO tDto = testConverter.toDTO(useranswer.getTest());
			useranswerdto = new UserAnswersDTO(useranswer.getId(), useranswer.getIdanswer(), useranswer.getIdtest(), useranswer.getIduser(),useranswer.getNumtest(), uDto,tDto);

		}
		return useranswerdto;
	}

}

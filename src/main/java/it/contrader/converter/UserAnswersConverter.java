package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.UserAnswersDTO;

import it.contrader.model.UserAnswers;

@Component
public class UserAnswersConverter extends AbstractConverter<UserAnswers, UserAnswersDTO>{

	@Override
	public UserAnswers toEntity(UserAnswersDTO useranswerdto) {
		UserAnswers useranswer = null;
		if (useranswerdto != null) {
			useranswer = new UserAnswers(useranswerdto.getId(), useranswerdto.getIdanswer(), useranswerdto.getIdtest(),useranswerdto.getIduser(),useranswerdto.getNumtest());
		}
		return useranswer;
	}

	@Override
	public UserAnswersDTO toDTO(UserAnswers useranswer) {
		UserAnswersDTO useranswerdto = null;
		if (useranswer != null) {
			useranswerdto = new UserAnswersDTO(useranswer.getId(), useranswer.getIdanswer(), useranswer.getIdtest(), useranswer.getIduser(),useranswer.getNumtest());

		}
		return useranswerdto;
	}

}

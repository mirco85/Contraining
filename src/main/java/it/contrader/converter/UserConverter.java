package it.contrader.converter;

import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.dto.UserAnswersDTO;
import it.contrader.dto.UserDTO;

import it.contrader.model.User;
import it.contrader.model.UserAnswers;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO> {
	
	private static UserAnswersConverter answerConverter = new UserAnswersConverter(); 
	
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			Set<UserAnswers> answers = answerConverter.toEntitySet(userDTO.getAnswers());
			user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype(), userDTO.getDatanascita(), userDTO.getFirstname(), userDTO.getLastname(), userDTO.getCodicefiscale(), answers);
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			Set<UserAnswersDTO> answers = answerConverter.toDTOSet(user.getAnswers());
			userDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getUsertype(), user.getDatanascita(), user.getFirstname(), user.getLastname(), user.getCodicefiscale(), answers);

		}
		return userDTO;
	}
}
package it.contrader.dto;

import java.util.Set;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

	private Long id;
	private String username;
	private String password;
	private Usertype usertype;

	private String datanascita;
	private String firstname;
	private String lastname;
	private String codicefiscale;
	
	private Set<UserAnswersDTO> answers;
	
}

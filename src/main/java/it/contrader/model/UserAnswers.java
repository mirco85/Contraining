package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserAnswers {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idanswer;
	private Long iduser;
	private Long idtest;
	private Long numtest;
	
	@ManyToOne
	@JoinColumn(name="id_user", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn (name ="id_test", nullable =false)
	private Test test;

}

package it.contrader.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="id_category", nullable=false)
	private Category category;
	private Long timeTest;
	private String testName;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="test_questions",
			joinColumns = { @JoinColumn(name = "id_test")},
			inverseJoinColumns = {@JoinColumn(name="id_question")}
			)
	private List<Questions> questions;
	
}
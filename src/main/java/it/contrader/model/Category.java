package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idcategory;
	
	@Column(unique = true)
	private String category;
}

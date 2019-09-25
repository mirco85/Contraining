package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import it.contrader.converter.TestConverter;
import it.contrader.dao.TestRepository;
import it.contrader.dto.TestDTO;
import it.contrader.model.Test;

@Service
public class TestService extends AbstractService<Test, TestDTO> {
	@Autowired
	private TestConverter converter;
	
	@Autowired
	private TestRepository repository;
	
	
}
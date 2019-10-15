package com.contrader.contraining.service.impl;

import com.contrader.contraining.service.TestsService;
import com.contrader.contraining.domain.Tests;
import com.contrader.contraining.repository.TestsRepository;
import com.contrader.contraining.service.dto.TestsDTO;
import com.contrader.contraining.service.mapper.TestsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Tests.
 */
@Service
@Transactional
public class TestsServiceImpl implements TestsService {

    private final Logger log = LoggerFactory.getLogger(TestsServiceImpl.class);

    private final TestsRepository testsRepository;

    private final TestsMapper testsMapper;

    public TestsServiceImpl(TestsRepository testsRepository, TestsMapper testsMapper) {
        this.testsRepository = testsRepository;
        this.testsMapper = testsMapper;
    }

    /**
     * Save a tests.
     *
     * @param testsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TestsDTO save(TestsDTO testsDTO) {
        log.debug("Request to save Tests : {}", testsDTO);
        Tests tests = testsMapper.toEntity(testsDTO);
        tests = testsRepository.save(tests);
        return testsMapper.toDto(tests);
    }

    /**
     * Get all the tests.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TestsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tests");
        return testsRepository.findAll(pageable)
            .map(testsMapper::toDto);
    }


    /**
     * Get one tests by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TestsDTO> findOne(Long id) {
        log.debug("Request to get Tests : {}", id);
        return testsRepository.findById(id)
            .map(testsMapper::toDto);
    }

    /**
     * Delete the tests by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Tests : {}", id);
        testsRepository.deleteById(id);
    }
}

package com.contrader.contraining.service.impl;

import com.contrader.contraining.service.AnswersService;
import com.contrader.contraining.domain.Answers;
import com.contrader.contraining.repository.AnswersRepository;
import com.contrader.contraining.service.dto.AnswersDTO;
import com.contrader.contraining.service.mapper.AnswersMapper;
import com.contrader.contraining.utils.MappableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Service Implementation for managing Answers.
 */
@Service
@Transactional
public class AnswersServiceImpl implements AnswersService {

    private final Logger log = LoggerFactory.getLogger(AnswersServiceImpl.class);

    private final AnswersRepository answersRepository;

    private final AnswersMapper answersMapper;

    public AnswersServiceImpl(AnswersRepository answersRepository, AnswersMapper answersMapper) {
        this.answersRepository = answersRepository;
        this.answersMapper = answersMapper;
    }

    /**
     * Save a answers.
     *
     * @param answersDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AnswersDTO save(AnswersDTO answersDTO) {
        log.debug("Request to save Answers : {}", answersDTO);
        Answers answers = answersMapper.toEntity(answersDTO);
        answers = answersRepository.save(answers);
        return answersMapper.toDto(answers);
    }

    /**
     * Get all the answers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AnswersDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Answers");
        return answersRepository.findAll(pageable)
            .map(answersMapper::toDto);
    }


    /**
     * Get one answers by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AnswersDTO> findOne(Long id) {
        log.debug("Request to get Answers : {}", id);
        return answersRepository.findById(id)
            .map(answersMapper::toDto);
    }

    /**
     * Delete the answers by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Answers : {}", id);
        answersRepository.deleteById(id);
    }

    @Override
    public List<AnswersDTO> findByQuestion(Long idQuestion) {
        log.debug("Request to get answer of question with id: " + idQuestion);

        return MappableList.map(answersRepository.getByQuestion(idQuestion), answersMapper::toDto);
    }

    @Override
    public List<AnswersDTO> findByUser(Long idUser) {
        log.debug("Request to get answers of user with id: " + idUser);
        return MappableList.map(answersRepository.getByUser(idUser), answersMapper::toDto);

    }

    @Override
    public List<AnswersDTO> findByQuestionAndUser(Long idQuestion, Long idUser) {
        log.debug("Request to get answers of question and user with idquestion: " + idQuestion + " and idUser: " + idUser);
        return MappableList.map(answersRepository.getByUserAndQuestion(idQuestion, idUser), answersMapper::toDto);
    }

    @Override
    public String getText(String text) {
        return "Hi! I'm answer service.\n" + text;
    }
}

package com.contrader.contraining.web.rest;

import com.contrader.contraining.AnswerApp;

import com.contrader.contraining.domain.Answers;
import com.contrader.contraining.repository.AnswersRepository;
import com.contrader.contraining.service.AnswersService;
import com.contrader.contraining.service.dto.AnswersDTO;
import com.contrader.contraining.service.mapper.AnswersMapper;
import com.contrader.contraining.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.contrader.contraining.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AnswersResource REST controller.
 *
 * @see AnswersResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnswerApp.class)
public class AnswersResourceIntTest {

    private static final Integer DEFAULT_ANSWER_POSITION = 1;
    private static final Integer UPDATED_ANSWER_POSITION = 2;

    private static final Long DEFAULT_ID_USER = 1L;
    private static final Long UPDATED_ID_USER = 2L;

    private static final Long DEFAULT_ID_QUESTION = 1L;
    private static final Long UPDATED_ID_QUESTION = 2L;

    @Autowired
    private AnswersRepository answersRepository;


    @Autowired
    private AnswersMapper answersMapper;
    

    @Autowired
    private AnswersService answersService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAnswersMockMvc;

    private Answers answers;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AnswersResource answersResource = new AnswersResource(answersService);
        this.restAnswersMockMvc = MockMvcBuilders.standaloneSetup(answersResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Answers createEntity(EntityManager em) {
        Answers answers = new Answers()
            .answerPosition(DEFAULT_ANSWER_POSITION)
            .idUser(DEFAULT_ID_USER)
            .idQuestion(DEFAULT_ID_QUESTION);
        return answers;
    }

    @Before
    public void initTest() {
        answers = createEntity(em);
    }

    @Test
    @Transactional
    public void createAnswers() throws Exception {
        int databaseSizeBeforeCreate = answersRepository.findAll().size();

        // Create the Answers
        AnswersDTO answersDTO = answersMapper.toDto(answers);
        restAnswersMockMvc.perform(post("/api/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answersDTO)))
            .andExpect(status().isCreated());

        // Validate the Answers in the database
        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeCreate + 1);
        Answers testAnswers = answersList.get(answersList.size() - 1);
        assertThat(testAnswers.getAnswerPosition()).isEqualTo(DEFAULT_ANSWER_POSITION);
        assertThat(testAnswers.getIdUser()).isEqualTo(DEFAULT_ID_USER);
        assertThat(testAnswers.getIdQuestion()).isEqualTo(DEFAULT_ID_QUESTION);
    }

    @Test
    @Transactional
    public void createAnswersWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = answersRepository.findAll().size();

        // Create the Answers with an existing ID
        answers.setId(1L);
        AnswersDTO answersDTO = answersMapper.toDto(answers);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAnswersMockMvc.perform(post("/api/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answersDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Answers in the database
        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkAnswerPositionIsRequired() throws Exception {
        int databaseSizeBeforeTest = answersRepository.findAll().size();
        // set the field null
        answers.setAnswerPosition(null);

        // Create the Answers, which fails.
        AnswersDTO answersDTO = answersMapper.toDto(answers);

        restAnswersMockMvc.perform(post("/api/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answersDTO)))
            .andExpect(status().isBadRequest());

        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIdUserIsRequired() throws Exception {
        int databaseSizeBeforeTest = answersRepository.findAll().size();
        // set the field null
        answers.setIdUser(null);

        // Create the Answers, which fails.
        AnswersDTO answersDTO = answersMapper.toDto(answers);

        restAnswersMockMvc.perform(post("/api/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answersDTO)))
            .andExpect(status().isBadRequest());

        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIdQuestionIsRequired() throws Exception {
        int databaseSizeBeforeTest = answersRepository.findAll().size();
        // set the field null
        answers.setIdQuestion(null);

        // Create the Answers, which fails.
        AnswersDTO answersDTO = answersMapper.toDto(answers);

        restAnswersMockMvc.perform(post("/api/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answersDTO)))
            .andExpect(status().isBadRequest());

        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAnswers() throws Exception {
        // Initialize the database
        answersRepository.saveAndFlush(answers);

        // Get all the answersList
        restAnswersMockMvc.perform(get("/api/answers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(answers.getId().intValue())))
            .andExpect(jsonPath("$.[*].answerPosition").value(hasItem(DEFAULT_ANSWER_POSITION)))
            .andExpect(jsonPath("$.[*].idUser").value(hasItem(DEFAULT_ID_USER.intValue())))
            .andExpect(jsonPath("$.[*].idQuestion").value(hasItem(DEFAULT_ID_QUESTION.intValue())));
    }
    

    @Test
    @Transactional
    public void getAnswers() throws Exception {
        // Initialize the database
        answersRepository.saveAndFlush(answers);

        // Get the answers
        restAnswersMockMvc.perform(get("/api/answers/{id}", answers.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(answers.getId().intValue()))
            .andExpect(jsonPath("$.answerPosition").value(DEFAULT_ANSWER_POSITION))
            .andExpect(jsonPath("$.idUser").value(DEFAULT_ID_USER.intValue()))
            .andExpect(jsonPath("$.idQuestion").value(DEFAULT_ID_QUESTION.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingAnswers() throws Exception {
        // Get the answers
        restAnswersMockMvc.perform(get("/api/answers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAnswers() throws Exception {
        // Initialize the database
        answersRepository.saveAndFlush(answers);

        int databaseSizeBeforeUpdate = answersRepository.findAll().size();

        // Update the answers
        Answers updatedAnswers = answersRepository.findById(answers.getId()).get();
        // Disconnect from session so that the updates on updatedAnswers are not directly saved in db
        em.detach(updatedAnswers);
        updatedAnswers
            .answerPosition(UPDATED_ANSWER_POSITION)
            .idUser(UPDATED_ID_USER)
            .idQuestion(UPDATED_ID_QUESTION);
        AnswersDTO answersDTO = answersMapper.toDto(updatedAnswers);

        restAnswersMockMvc.perform(put("/api/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answersDTO)))
            .andExpect(status().isOk());

        // Validate the Answers in the database
        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeUpdate);
        Answers testAnswers = answersList.get(answersList.size() - 1);
        assertThat(testAnswers.getAnswerPosition()).isEqualTo(UPDATED_ANSWER_POSITION);
        assertThat(testAnswers.getIdUser()).isEqualTo(UPDATED_ID_USER);
        assertThat(testAnswers.getIdQuestion()).isEqualTo(UPDATED_ID_QUESTION);
    }

    @Test
    @Transactional
    public void updateNonExistingAnswers() throws Exception {
        int databaseSizeBeforeUpdate = answersRepository.findAll().size();

        // Create the Answers
        AnswersDTO answersDTO = answersMapper.toDto(answers);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restAnswersMockMvc.perform(put("/api/answers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(answersDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Answers in the database
        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAnswers() throws Exception {
        // Initialize the database
        answersRepository.saveAndFlush(answers);

        int databaseSizeBeforeDelete = answersRepository.findAll().size();

        // Get the answers
        restAnswersMockMvc.perform(delete("/api/answers/{id}", answers.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Answers> answersList = answersRepository.findAll();
        assertThat(answersList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Answers.class);
        Answers answers1 = new Answers();
        answers1.setId(1L);
        Answers answers2 = new Answers();
        answers2.setId(answers1.getId());
        assertThat(answers1).isEqualTo(answers2);
        answers2.setId(2L);
        assertThat(answers1).isNotEqualTo(answers2);
        answers1.setId(null);
        assertThat(answers1).isNotEqualTo(answers2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AnswersDTO.class);
        AnswersDTO answersDTO1 = new AnswersDTO();
        answersDTO1.setId(1L);
        AnswersDTO answersDTO2 = new AnswersDTO();
        assertThat(answersDTO1).isNotEqualTo(answersDTO2);
        answersDTO2.setId(answersDTO1.getId());
        assertThat(answersDTO1).isEqualTo(answersDTO2);
        answersDTO2.setId(2L);
        assertThat(answersDTO1).isNotEqualTo(answersDTO2);
        answersDTO1.setId(null);
        assertThat(answersDTO1).isNotEqualTo(answersDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(answersMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(answersMapper.fromId(null)).isNull();
    }
}

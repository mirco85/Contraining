package com.contrader.contraining.repository;

import com.contrader.contraining.domain.Answers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Answers entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {

    @Query("SELECT a FROM Answers a WHERE idQuestion = ?1")
    List<Answers> getByQuestion(Long idQuestion);

    @Query("SELECT a FROM Answers a WHERE idUser = ?1")
    List<Answers> getByUser(Long idUser);

    @Query("SELECT a FROM Answers a WHERE idQuestion = ?1 and idUser = ?2")
    List<Answers> getByUserAndQuestion(Long idQuestion, Long idUser);
}

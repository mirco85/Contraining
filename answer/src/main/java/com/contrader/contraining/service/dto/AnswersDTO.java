package com.contrader.contraining.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Answers entity.
 */
public class AnswersDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer answerPosition;

    @NotNull
    private Long idUser;

    @NotNull
    private Long idQuestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(Integer answerPosition) {
        this.answerPosition = answerPosition;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnswersDTO answersDTO = (AnswersDTO) o;
        if (answersDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), answersDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AnswersDTO{" +
            "id=" + getId() +
            ", answerPosition=" + getAnswerPosition() +
            ", idUser=" + getIdUser() +
            ", idQuestion=" + getIdQuestion() +
            "}";
    }
}

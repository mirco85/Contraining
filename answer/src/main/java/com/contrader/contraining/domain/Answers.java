package com.contrader.contraining.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Answers.
 */
@Entity
@Table(name = "answers")
public class Answers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "answer_position", nullable = false)
    private Integer answerPosition;

    @NotNull
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @NotNull
    @Column(name = "id_question", nullable = false)
    private Long idQuestion;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnswerPosition() {
        return answerPosition;
    }

    public Answers answerPosition(Integer answerPosition) {
        this.answerPosition = answerPosition;
        return this;
    }

    public void setAnswerPosition(Integer answerPosition) {
        this.answerPosition = answerPosition;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Answers idUser(Long idUser) {
        this.idUser = idUser;
        return this;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public Answers idQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
        return this;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answers answers = (Answers) o;
        if (answers.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), answers.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Answers{" +
            "id=" + getId() +
            ", answerPosition=" + getAnswerPosition() +
            ", idUser=" + getIdUser() +
            ", idQuestion=" + getIdQuestion() +
            "}";
    }
}

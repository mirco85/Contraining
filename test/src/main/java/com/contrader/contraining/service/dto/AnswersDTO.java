package com.contrader.contraining.service.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "answerPosition",
    "id",
    "idQuestion",
    "idUser"
})
public class AnswersDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("answerPosition")
    private Integer answerPosition;

    @JsonProperty("idUser")
    private Long idUser;


    @JsonProperty("idQuestion")
    private Long idQuestion;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("answerPosition")
    public Integer getAnswerPosition() {
        return answerPosition;
    }

    public AnswersDTO answerPosition(Integer answerPosition) {
        this.answerPosition = answerPosition;
        return this;
    }

    @JsonProperty("answerPosition")
    public void setAnswerPosition(Integer answerPosition) {
        this.answerPosition = answerPosition;
    }

    @JsonProperty("idUser")
    public Long getIdUser() {
        return idUser;
    }

    public AnswersDTO idUser(Long idUser) {
        this.idUser = idUser;
        return this;
    }

    @JsonProperty("idUser")
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @JsonProperty("idQuestion")
    public Long getIdQuestion() {
        return idQuestion;
    }

    public AnswersDTO idQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
        return this;
    }

    @JsonProperty("idQuestion")
    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnswersDTO answers = (AnswersDTO) o;
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
        return "AnswersDTO{" +
            "id=" + getId() +
            ", answerPosition=" + getAnswerPosition() +
            ", idUser=" + getIdUser() +
            ", idQuestion=" + getIdQuestion() +
            "}";
    }*/
}

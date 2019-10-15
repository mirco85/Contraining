package com.contrader.contraining.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Questions.
 */
@Entity
@Table(name = "questions")
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "answer_1")
    private String answer1;

    @Column(name = "answer_2")
    private String answer2;

    @Column(name = "answer_3")
    private String answer3;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Tests tests;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Questions text(String text) {
        this.text = text;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer1() {
        return answer1;
    }

    public Questions answer1(String answer1) {
        this.answer1 = answer1;
        return this;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public Questions answer2(String answer2) {
        this.answer2 = answer2;
        return this;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public Questions answer3(String answer3) {
        this.answer3 = answer3;
        return this;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public Tests getTests() {
        return tests;
    }

    public Questions tests(Tests tests) {
        this.tests = tests;
        return this;
    }

    public void setTests(Tests tests) {
        this.tests = tests;
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
        Questions questions = (Questions) o;
        if (questions.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), questions.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Questions{" +
            "id=" + getId() +
            ", text='" + getText() + "'" +
            ", answer1='" + getAnswer1() + "'" +
            ", answer2='" + getAnswer2() + "'" +
            ", answer3='" + getAnswer3() + "'" +
            "}";
    }
}

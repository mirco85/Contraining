package com.contrader.contraining.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Tests.
 */
@Entity
@Table(name = "tests")
public class Tests implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "test_name", nullable = false)
    private String testName;

    @Column(name = "time_test")
    private Long timeTest;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Categories categories;

    @OneToMany(mappedBy = "tests")
    private Set<Questions> questions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public Tests testName(String testName) {
        this.testName = testName;
        return this;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Long getTimeTest() {
        return timeTest;
    }

    public Tests timeTest(Long timeTest) {
        this.timeTest = timeTest;
        return this;
    }

    public void setTimeTest(Long timeTest) {
        this.timeTest = timeTest;
    }

    public Categories getCategories() {
        return categories;
    }

    public Tests categories(Categories categories) {
        this.categories = categories;
        return this;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Set<Questions> getQuestions() {
        return questions;
    }

    public Tests questions(Set<Questions> questions) {
        this.questions = questions;
        return this;
    }

    public Tests addQuestions(Questions questions) {
        this.questions.add(questions);
        questions.setTests(this);
        return this;
    }

    public Tests removeQuestions(Questions questions) {
        this.questions.remove(questions);
        questions.setTests(null);
        return this;
    }

    public void setQuestions(Set<Questions> questions) {
        this.questions = questions;
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
        Tests tests = (Tests) o;
        if (tests.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tests.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Tests{" +
            "id=" + getId() +
            ", testName='" + getTestName() + "'" +
            ", timeTest=" + getTimeTest() +
            "}";
    }
}

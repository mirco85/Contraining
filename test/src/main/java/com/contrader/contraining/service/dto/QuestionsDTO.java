package com.contrader.contraining.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Questions entity.
 */
public class QuestionsDTO implements Serializable {

    private Long id;

    @NotNull
    private String text;

    private String answer1;

    private String answer2;

    private String answer3;

    private Long testsId;

    private String testsTestName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public Long getTestsId() {
        return testsId;
    }

    public void setTestsId(Long testsId) {
        this.testsId = testsId;
    }

    public String getTestsTestName() {
        return testsTestName;
    }

    public void setTestsTestName(String testsTestName) {
        this.testsTestName = testsTestName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QuestionsDTO questionsDTO = (QuestionsDTO) o;
        if (questionsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), questionsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "QuestionsDTO{" +
            "id=" + getId() +
            ", text='" + getText() + "'" +
            ", answer1='" + getAnswer1() + "'" +
            ", answer2='" + getAnswer2() + "'" +
            ", answer3='" + getAnswer3() + "'" +
            ", tests=" + getTestsId() +
            ", tests='" + getTestsTestName() + "'" +
            "}";
    }
}

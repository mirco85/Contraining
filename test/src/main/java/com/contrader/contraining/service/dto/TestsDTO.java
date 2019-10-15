package com.contrader.contraining.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Tests entity.
 */
public class TestsDTO implements Serializable {

    private Long id;

    @NotNull
    private String testName;

    private Long timeTest;

    private Long categoriesId;

    private String categoriesCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Long getTimeTest() {
        return timeTest;
    }

    public void setTimeTest(Long timeTest) {
        this.timeTest = timeTest;
    }

    public Long getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getCategoriesCategory() {
        return categoriesCategory;
    }

    public void setCategoriesCategory(String categoriesCategory) {
        this.categoriesCategory = categoriesCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestsDTO testsDTO = (TestsDTO) o;
        if (testsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), testsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TestsDTO{" +
            "id=" + getId() +
            ", testName='" + getTestName() + "'" +
            ", timeTest=" + getTimeTest() +
            ", categories=" + getCategoriesId() +
            ", categories='" + getCategoriesCategory() + "'" +
            "}";
    }
}

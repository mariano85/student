package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public final class Subject {
    @NotNull(message = "Subject name must not be null")
    private final String name;
    @NotNull(message = "Subject Qualification must not be null")
    @Min(value = 1, message = "Subject Qualification must be >= 1")
    @Max(value = 10, message = "Subject Qualification must be <= 10")
    private final Integer qualification;

    public Integer getQualification(){
        return this.qualification;
    }

    public String getName(){
        return this.name;
    }

    public Subject(String name, Integer qualification){
        this.name = name;
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name) && Objects.equals(qualification, subject.qualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, qualification);
    }
}


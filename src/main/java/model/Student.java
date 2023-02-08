package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

public final class Student {

    @NotNull(message = "name must not be null")
    private final String name;

    @NotNull(message = "age must not be null")
    @Min(value = 7, message = "age must be >= 7")
    @Max(value = 100, message = "age must be <= 100")
    private final Integer age;

    @NotNull(message = "end course date must not be null")
    private final EndCourseDate endCourseDate;

    @NotNull(message = "studied subjects must not be null")
    private final Set<Subject> studiedSubjects;

    public String getName(){
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }

    public EndCourseDate getEndCourseDate() {
        return endCourseDate;
    }

    public Set<Subject> getStudiedSubjects(){
        return Set.copyOf(this.studiedSubjects);
    }

    public Student(String name, Integer age, EndCourseDate date, Set<Subject> subjects){
        this.name = name;
        this.age = age;
        this.endCourseDate = date;
        this.studiedSubjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(endCourseDate, student.endCourseDate) && Objects.equals(studiedSubjects, student.studiedSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, endCourseDate, studiedSubjects);
    }
}

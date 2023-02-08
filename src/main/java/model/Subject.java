package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public final class Subject {
    @NotNull(message = "Subject name must not be null")
    final String name;
    @NotNull(message = "Subject Qualification must not be null")
    @Min(value = 1, message = "Subject Qualification must be >= 1")
    @Max(value = 10, message = "Subject Qualification must be <= 10")
    final Integer qualification;

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


}


package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class EndCourseDate {

    @NotNull(message = "Day must not be null")
    @Min(value = 1, message = "Day should not be less than 1")
    @Max(value = 31, message = "Day should not be greater than 31")
    final String day;
    @NotNull(message = "Month must not be null")
    @Min(value = 1, message = "Month should not be less than 1")
    @Max(value = 12, message = "Month should not be greater than 12")
    final String month;
    SimpleDateFormat format = new SimpleDateFormat("dd-MM");

    public EndCourseDate(String day, String month) throws ParseException {
        String attr = day + "-" + month;
        format.parse(attr);
        this.day = day;
        this.month = month;
    }

    public String getEndCourseDate() {
        return day + "-" + month;
    }

}

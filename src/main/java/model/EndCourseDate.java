package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class EndCourseDate {

    @NotNull(message = "Day must not be null")
    @Min(value = 1, message = "Day should not be less than 1")
    @Max(value = 31, message = "Day should not be greater than 31")
    private final String day;
    @NotNull(message = "Month must not be null")
    @Min(value = 1, message = "Month should not be less than 1")
    @Max(value = 12, message = "Month should not be greater than 12")
    private final String month;
    private final SimpleDateFormat format = new SimpleDateFormat("dd-MM");

    public EndCourseDate(String day, String month) throws ParseException {
        String attr = day + "-" + month;
        format.parse(attr);
        this.day = day;
        this.month = month;
    }

    public String getEndCourseDate() {
        return day + "-" + month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndCourseDate that = (EndCourseDate) o;
        return Objects.equals(day, that.day) && Objects.equals(month, that.month) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, format);
    }
}

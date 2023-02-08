package test.model.student;

import model.EndCourseDate;
import model.Student;
import model.Subject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Correct student")
    public void correctStudent() throws ParseException {
        Student s = new Student("pepe",18,new EndCourseDate("1","1"), java.util.Set.of(new Subject("lengua", 9)));
                Set<ConstraintViolation<Student>> constraintViolations =
                        validator.validate( s );
        assertEquals( 0, constraintViolations.size() );

    }

    @Test
    @DisplayName("Name is null")
    public void nameIsNull() throws ParseException {
        Student s = new Student(null,18,new EndCourseDate("1","1"), java.util.Set.of(new Subject("lengua", 9)));
        Set<ConstraintViolation<Student>> constraintViolations =
                validator.validate( s );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "name must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("Age is null")
    public void ageIsNull() throws ParseException {
        Student s = new Student("pepe",null,new EndCourseDate("1","1"), java.util.Set.of(new Subject("lengua", 9)));
        Set<ConstraintViolation<Student>> constraintViolations =
                validator.validate( s );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "age must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("end course date is null")
    public void endCourseDateIsNull(){
        Student s = new Student("pepe",18, null, java.util.Set.of(new Subject("lengua", 9)));
        Set<ConstraintViolation<Student>> constraintViolations =
                validator.validate( s );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "end course date must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("studied subjects are null")
    public void studiedSubjectAreNull() throws ParseException {
        Student s = new Student("pepe",18, new EndCourseDate("1","1"), null);
        Set<ConstraintViolation<Student>> constraintViolations =
                validator.validate( s );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "studied subjects must not be null",
                constraintViolations.iterator().next().getMessage()
        );

    }

    @Test
    @DisplayName("age is too small")
    public void ageIsSmall() throws ParseException {
        Student s = new Student("pepe",6,new EndCourseDate("1","1"), java.util.Set.of(new Subject("lengua", 9)));
        Set<ConstraintViolation<Student>> constraintViolations =
                validator.validate( s );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "age must be >= 7",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("age is too big")
    public void ageIsTooBig() throws ParseException {
        EndCourseDate date = new EndCourseDate("1","1");
        Student s = new Student("pepe",182,date, java.util.Set.of(new Subject("lengua", 9)));
        Set<ConstraintViolation<Student>> constraintViolations =
                validator.validate( s );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "age must be <= 100",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("day is null")
    public void dayIsNull() throws ParseException {
        EndCourseDate date = null;
        try {
            date = new EndCourseDate(null,"1");
        } catch (Exception e){
            assertEquals(ParseException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Month is null")
    public void monthIsNull() throws ParseException {
        EndCourseDate date = null;
        try {
            date = new EndCourseDate("1",null);
        } catch (Exception e){
            assertEquals(ParseException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("day is too small")
    public void dayIsTooSmall() throws ParseException {
        EndCourseDate date = new EndCourseDate("-1","1");
        Set<ConstraintViolation<EndCourseDate>> constraintViolations =
                validator.validate( date );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Day should not be less than 1",
                constraintViolations.iterator().next().getMessage()
        );

    }

    @Test
    @DisplayName("day is too small")
    public void dayIsTooBig() throws ParseException {
        EndCourseDate date = new EndCourseDate("32","1");
        Set<ConstraintViolation<EndCourseDate>> constraintViolations =
                validator.validate( date );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Day should not be greater than 31",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("month is too small")
    public void monthIsTooSmall() throws ParseException {
        EndCourseDate date = new EndCourseDate("2","-1");
        Set<ConstraintViolation<EndCourseDate>> constraintViolations =
                validator.validate( date );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Month should not be less than 1",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("month is too big")
    public void monthIsTooBig() throws ParseException {
        EndCourseDate date = new EndCourseDate("2","13");
        Set<ConstraintViolation<EndCourseDate>> constraintViolations =
                validator.validate( date );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Month should not be greater than 12",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("subject name is null")
    public void subjectNameIsNull() throws ParseException {
        Subject subject = new Subject(null, 9);
        Set<ConstraintViolation<Subject>> constraintViolations =
                validator.validate( subject );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Subject name must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("subject qualification is null")
    public void subjectQualificationIsNull() throws ParseException {
        Subject subject = new Subject("lengua", null);
        Set<ConstraintViolation<Subject>> constraintViolations =
                validator.validate( subject );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Subject Qualification must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("subject qualification is too small")
    public void subjectQualificationIsTooSmall() throws ParseException {
        Subject subject = new Subject("lengua", -1);
        Set<ConstraintViolation<Subject>> constraintViolations =
                validator.validate( subject );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Subject Qualification must be >= 1",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    @DisplayName("subject qualification is too small")
    public void subjectQualificationIsTooBig() throws ParseException {
        Subject subject = new Subject("lengua", 11);
        Set<ConstraintViolation<Subject>> constraintViolations =
                validator.validate( subject );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Subject Qualification must be <= 10",
                constraintViolations.iterator().next().getMessage()
        );
    }
}

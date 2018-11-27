import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SchoolTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private static String SCHOOL_NAME = "TestSchool";
    private static Date OPENING_DATE;
    private static List<Course> COURSES = new ArrayList<>();

    static {
        try {
            OPENING_DATE = sdf.parse("01-09-2018");

            COURSES.add(new Course("Course1", sdf.parse("27-11-2018"), sdf.parse("28-11-2018")));
            COURSES.add(new Course("Course2", sdf.parse("27-11-2018"), sdf.parse("28-11-2018")));
            COURSES.add(new Course("Course3", sdf.parse("27-11-2018"), sdf.parse("28-11-2018")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SchoolObjectHasAName() {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);

        // assert
        assertFalse(school.getName() == null);
    }

    @Test
    public void SchoolObjectHasOpeningDate() {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);

        // assert
        assertFalse(school.getOpeningDate() == null);
    }

    @Test
    public void SchoolObjectHasCollectionOfCourses() {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);

        // assert
        assertFalse(school.getCourses() == null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SchoolNameCannotBeNull() throws NullPointerException {
        // arrange
        School school;

        // act
        school = new School(null, OPENING_DATE, COURSES);

        // assert
    }

    @Test(expected = IllegalArgumentException.class)
    public void OpeningDateCannotBeNull() throws NullPointerException {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, null, COURSES);

        // assert
    }

    @Test
    public void AddNewCourseToSchool() throws ParseException, CourseDateException {
        // arrange
        School school = new School(SCHOOL_NAME, OPENING_DATE, null);
        int nrOfCourses = school.getCourses().size();
        Course newCourse = new Course("New Course", sdf.parse("27-11-2018"), sdf.parse("28-11-2018"));

        // act
        school.addCourse(newCourse);

        // assert
        assertEquals(0, nrOfCourses);
        assertTrue(school.getCourses().contains(newCourse));
        assertEquals(1, school.getCourses().size());
    }
}
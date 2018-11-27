import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SchoolTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private static final String SCHOOL_NAME = "TestSchool";
    private static Date OPENING_DATE;
    private static final List<Course> COURSES = new ArrayList<>();

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
    public void SchoolObjectHasAName() throws CourseException, DuplicateCourseException {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);

        // assert
        assertNotNull(school.getName());
    }

    @Test
    public void SchoolObjectHasOpeningDate() throws CourseException, DuplicateCourseException {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);

        // assert
        assertNotNull(school.getOpeningDate());
    }

    @Test
    public void SchoolObjectHasCollectionOfCourses() throws CourseException, DuplicateCourseException {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);

        // assert
        assertNotNull(school.getCourses());
    }

    @Test(expected = IllegalArgumentException.class)
    public void SchoolNameCannotBeNull() throws NullPointerException, CourseException, DuplicateCourseException {
        // arrange
        School school;

        // act
        school = new School(null, OPENING_DATE, COURSES);

        // assert
    }

    @Test(expected = IllegalArgumentException.class)
    public void OpeningDateCannotBeNull() throws NullPointerException, CourseException, DuplicateCourseException {
        // arrange
        School school;

        // act
        school = new School(SCHOOL_NAME, null, COURSES);

        // assert
    }

    @Test
    public void AddNewCourseToSchool() throws ParseException, CourseDateException, CourseException, DuplicateCourseException {
        // arrange
        School school = new School(SCHOOL_NAME, OPENING_DATE, new ArrayList<>());
        int nrOfCourses = school.getCourses().size();
        Course newCourse = new Course("New Course", sdf.parse("27-11-2018"), sdf.parse("28-11-2018"));

        // act
        school.addCourse(newCourse);

        // assert
        assertEquals(0, nrOfCourses);
        assertTrue(school.getCourses().contains(newCourse));
        assertEquals(1, school.getCourses().size());
    }

    @Test(expected = CourseException.class)
    public void IfCourseBeginDateBeforeSchoolOpeningDateAtSchoolCreationThrowCourseException() throws ParseException, CourseException, CourseDateException, DuplicateCourseException {
        // arrange
        School school;
        List<Course> wrongCourses = new ArrayList<>();
        wrongCourses.add(new Course("wrongCourse1", sdf.parse("01-08-2018"), sdf.parse("02-09-2018")));

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, wrongCourses);

        // assert
    }

    @Test(expected = CourseException.class)
    public void NewCourseBeginDateBeforeSchoolOpeningDateThrowsCourseException() throws ParseException, CourseException, CourseDateException, DuplicateCourseException {
        // arrange
        School school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);
        Course wrongCourse = new Course("wrongCourse", sdf.parse("01-08-2018"), sdf.parse("02-09-2018"));

        // act
        school.addCourse(wrongCourse);

        // assert
    }

    @Test(expected = DuplicateCourseException.class)
    public void IfCourseNameNotUniqueAtSchoolCreationThrowException() throws ParseException, CourseException, CourseDateException, DuplicateCourseException {
        // arrange
        School school;
        List<Course> wrongCourses = new ArrayList<>();
        wrongCourses.add(new Course("duplicateName", sdf.parse("27-11-2018"), sdf.parse("28-11-2018")));
        wrongCourses.add(new Course("duplicateName", sdf.parse("27-11-2018"), sdf.parse("28-11-2018")));

        // act
        school = new School(SCHOOL_NAME, OPENING_DATE, wrongCourses);

        // assert
    }

    @Test
    public void CanGetCourseByName() throws DuplicateCourseException, CourseException {
        // arrange
        School school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);
        String knownCourseName = COURSES.get(0).getName();

        // act
        Course foundCourse = school.getCourse(knownCourseName);

        // assert
        assertEquals(COURSES.get(0), foundCourse);
    }

    @Test
    public void GetCourseNamesTest() throws DuplicateCourseException, CourseException {
        // arrange
        School school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);
        List<String> courseNames = new ArrayList<>();
        for (Course c : COURSES) {
            courseNames.add(c.getName());
        }

        // act
        List<String> foundCourseNames = school.getCourseNames();

        // assert
        assertEquals(COURSES.size(), courseNames.size());
        assertEquals(courseNames, foundCourseNames);
    }

    @Test
    public void GetCopiesOfCoursesTest() throws DuplicateCourseException, CourseException {
        // arrange
        School school = new School(SCHOOL_NAME, OPENING_DATE, COURSES);

        // act
        List<Course> courseCopies = school.getCourseCopies();

        // assert
        assertArrayEquals(COURSES.toArray(), courseCopies.toArray());
    }
}
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CourseTest {

    private static String COURSE_NAME = "TestCourse";

    @Test(expected = CourseDateException.class)
    public void endDateBeforeBeginDateThrowsException() throws CourseDateException {
        // arrange
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date beginDate = new Date();
        Date endDate = new Date();
        try {
            beginDate = dateFormat.parse("28-11-2018");
            endDate = dateFormat.parse("27-11-2018");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        // act
        Course course = new Course(COURSE_NAME, beginDate, endDate);

        // assert
    }
}
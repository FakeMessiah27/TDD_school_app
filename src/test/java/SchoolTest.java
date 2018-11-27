import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SchoolTest {

    private static String SCHOOL_NAME = "TestSchool";
    private static Date openingDate;

    static {
        try {
            openingDate = new SimpleDateFormat("dd-MM-yyyy").parse("01-09-2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SchoolObjectHasAName() {
        // arrange
        School school = new School(SCHOOL_NAME);
        String expectedSchoolName = "TestSchool";

        // act
        String schoolName = school.getName();

        // assert
        assertEquals(schoolName, expectedSchoolName);
    }

    @Test
    public void SchoolObjectHasOpeningDate() {
        // arrange
        School school = new School(SCHOOL_NAME, openingDate);

        // act


        // assert
        assertFalse(school.getOpeningDate() == null);
    }
}
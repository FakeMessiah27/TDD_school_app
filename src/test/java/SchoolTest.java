import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolTest {

    private static String SCHOOL_NAME = "TestSchool";

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
}
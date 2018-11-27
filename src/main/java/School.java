import org.apache.commons.lang.Validate;

import java.util.Date;
import java.util.List;

public class School {

    private String name;
    private Date openingDate;
    private List<Course> courses;

    public School(String name, Date openingDate, List<Course> courses) throws CourseException {

        // Validate parameters
        Validate.notNull(name, "School name cannot be null");
        Validate.notNull(openingDate, "Opening date cannot be null");

        for (Course c : courses) {
            if (c.getStartDate().before(openingDate)) {
                throw new CourseException(c.getName());
            }
        }

        // Set parameters
        this.name = name;
        this.openingDate = openingDate;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}

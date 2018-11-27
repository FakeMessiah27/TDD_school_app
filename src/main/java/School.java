import org.apache.commons.lang.Validate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class School {

    private String name;
    private Date openingDate;
    private List<Course> courses;

    public School(String name, Date openingDate, List<Course> courses) throws CourseException, DuplicateCourseException {

        // Validate parameters
        Validate.notNull(name, "School name cannot be null");
        Validate.notNull(openingDate, "Opening date cannot be null");

        for (Course c : courses) {
            if (c.getStartDate().before(openingDate)) {
                throw new CourseException(c.getName());
            }
        }

        if (courseListContainsDuplicates(courses))
            throw new DuplicateCourseException();

        // Set parameters
        this.name = new String(name);
        this.openingDate = openingDate;
        this.courses = new ArrayList<>(courses);
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

    public void addCourse(Course course) throws CourseException {
        if (course.getStartDate().before(openingDate)) {
            throw new CourseException(course.getName());
        }

        courses.add(course);
    }

    private boolean courseListContainsDuplicates(List<Course> courses) {
        List<String> foundNames = new ArrayList<>();

        for (Course c : courses) {
            if (foundNames.contains(c.getName())) {
                return true;
            }
            else {
                foundNames.add(c.getName());
            }
        }

        return false;
    }

    public Course getCourse(String courseName) {
        for (Course c : courses) {
            if (c.getName() == courseName) {
                return c;
            }
        }

        return null;
    }

    public List<String> getCourseNames() {
        List<String> courseNames = new ArrayList<>();

        for (Course c : courses) {
            courseNames.add(c.getName());
        }

        return courseNames;
    }

    public List<Course> getCourseCopies() {
        return new ArrayList<>(courses);
    }
}

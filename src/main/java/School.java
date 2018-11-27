import java.util.Date;
import java.util.List;

public class School {

    private String name;
    private Date openingDate;
    private List<Course> courses;

    public School(String name, Date openingDate, List<Course> courses) {
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
}

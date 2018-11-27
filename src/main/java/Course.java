import java.util.Date;

public class Course {
    private String name;
    private Date startDate;
    private Date endDate;

    public Course(String name, Date startDate, Date endDate) throws CourseDateException {
        if (startDate.after(endDate)) {
            throw new CourseDateException();
        }
        else {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}

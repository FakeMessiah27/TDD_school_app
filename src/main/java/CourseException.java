public class CourseException extends Exception {

    private String courseName;

    public CourseException(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {
        return courseName + "'s start date is before the opening date of the school!";
    }
}

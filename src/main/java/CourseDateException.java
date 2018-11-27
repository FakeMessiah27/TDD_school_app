public class CourseDateException extends Exception {

    public String toString() {
        return "The endDate cannot be before the startDate!";
    }
}

import java.util.Date;

public class School {

    private String name;
    private Date openingDate;

    public School(String name, Date openingDate) {
        this.name = name;
        this.openingDate = openingDate;
    }

    public String getName() {
        return name;
    }

    public Date getOpeningDate() {
        return openingDate;
    }
}

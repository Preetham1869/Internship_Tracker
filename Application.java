import java.util.Date;

public class Application {
    String companyName;
    String role;
    String status;
    Date dateApplied;

    public Application(String companyName, String role, String status, Date dateApplied) {
        this.companyName = companyName;
        this.role = role;
        this.status = status;
        this.dateApplied = dateApplied;
    }

    public String toString() {
        return "Company: " + companyName + ", Role: " + role + ", Status: " + status + ", Applied on: " + dateApplied;
    }
}

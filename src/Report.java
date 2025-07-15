import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Report {
    private String reportId;
    private String dateCreated;

    public Report(String reportId) {
        this.reportId = reportId;
        this.dateCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public void displayReport(ArrayList<User> userList) {
        System.out.println("=============== Report Details ===============");
        System.out.println("Report ID: " + this.reportId);
        System.out.println("Date Generated: " + this.dateCreated);
        System.out.println("----------------------------------------------");
        
        System.out.println("Users: ");
        if (userList.isEmpty()) {
            System.out.println("No users");
        }
        else {
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(i+1 + ". " + userList.get(i).toString());
            }
        }
    }
}

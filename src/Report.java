import java.time.LocalDateTime;


public class Report {
    private String reportId;
    private LocalDateTime dateCreated;

    public Report(String reportId) {
        this.reportId = reportId;
        this.dateCreated = LocalDateTime.now();
    }

    public void displayReport() {
        System.out.println("=== Report Details ===");
        System.out.println("Report ID: " + this.reportId);
        System.out.println("Date Generated: " + this.dateCreated);
        // display transaction 
        // display loan

    }
}

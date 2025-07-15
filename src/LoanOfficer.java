import java.util.ArrayList;
import java.util.List;

public class LoanOfficer extends User {
    private List<Loan> processedLoans = new ArrayList<>();
    private List<Loan> pendingLoans = new ArrayList<>();

    public LoanOfficer(String id, String name, String email, String password) {
        super(id, name, email, password, "LoanOfficer");
    }

    public void addPendingLoan(Loan loan) {
        pendingLoans.add(loan);
    }

    public List<Loan> getPendingLoans() {
        return pendingLoans;
    }

    public void approveLoan(Loan loan) {
        loan.setLoanOfficer(this);
        processedLoans.add(loan);
        System.out.println("Loan " + loan.getLoanId() + " approved by Officer " + super.getName());
    }

    public void rejectLoan(Loan loan) {
        loan.setLoanOfficer(this);
        processedLoans.add(loan);
        System.out.println("Loan " + loan.getLoanId() + " rejected by Officer " + super.getName());
    }

    public List<Loan> getProcessedLoans() {
        return processedLoans;
    }
}
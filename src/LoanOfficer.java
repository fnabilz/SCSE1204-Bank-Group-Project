import java.util.ArrayList;
import java.util.List;

public class LoanOfficer extends User {
    private List<Loan> processedLoans = new ArrayList<>();

    public LoanOfficer(String id, String name, String email, String password) {
        super(id, name, email, password, "LoanOfficer");
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
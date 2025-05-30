import java.util.ArrayList;
import java.util.List;

public class LoanOfficer {
    private String officerId;
    private String name;
    private List<Loan> processedLoans = new ArrayList<>();

    // jangan lupa extends user bos
    public LoanOfficer(String officerId, String name) {
        this.officerId = officerId;
        this.name = name;
    }

    public String getOfficerId() {
        return officerId;
    }

    public String getName() {
        return name;
    }

    public void approveLoan(Loan loan) {
        loan.setLoanOfficer(this);
        processedLoans.add(loan);
        System.out.println("Loan " + loan.getLoanId() + " approved by Officer " + name);
    }

    public void rejectLoan(Loan loan) {
        loan.setLoanOfficer(this);
        processedLoans.add(loan);
        System.out.println("Loan " + loan.getLoanId() + " rejected by Officer " + name);
    }

    public List<Loan> getProcessedLoans() {
        return processedLoans;
    }
}
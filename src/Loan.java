import java.util.Date;

// Loan class
class Loan {
    private String loanType;
    private String loanId;
    private double amount;
    private double interestRate;
    private int term;
    private Date applicationDate;
    private Date approvalDate;
    private LoanOfficer loanOfficer; // Add loanOffcer

    public Loan(String loanId, String loanType, double amount, double interestRate, int term, Date applicationDate, Date approvalDate) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
        this.applicationDate = applicationDate;
        this.approvalDate = approvalDate;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }


    public Date getApplicationDate() {
        return applicationDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setLoanOfficer(LoanOfficer loanOfficer) {
        this.loanOfficer = loanOfficer;
    }

    public LoanOfficer getLoanOfficer() {
        return loanOfficer;
    }

    // Calculate monthly payment using amortization formula
    public double calculateMonthlyPayment() {
        double monthlyRate = interestRate / 12 / 100;
        int numberOfPayments = term * 12;
        if (monthlyRate == 0) {
            return amount / numberOfPayments;
        }
        return (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments));
    }

    // Calculate total payment over the loan term
    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * term * 12;
    }

    // Calculate total interest paid over the loan term
    public double calculateTotalInterest() {
        return calculateTotalPayment() - amount;
    }

    
    @Override
    public String toString() {
        return "Loan{" +
                "loanType='" + loanType + '\'' +
                ", loanId='" + loanId + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", term=" + term +
                ", applicationDate=" + applicationDate +
                ", approvalDate=" + approvalDate +
                ", loanOfficer=" + (loanOfficer != null ? loanOfficer.getName() : "None") +
                '}';
    }
}
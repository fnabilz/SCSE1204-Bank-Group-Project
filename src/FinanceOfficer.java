import java.util.Scanner; 

class FinanceOfficer {
    private double divRate;
    private Scanner scan;

    public FinanceOfficer(Scanner scan) {
        this.scan = scan;
    }

    public void setDiv() {
        System.out.print("Dividend rate for this year: ");
        divRate = scan.nextDouble();
    }

    public double getDiv() {
        return divRate;
    }
}

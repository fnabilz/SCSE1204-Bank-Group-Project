import java.util.Scanner; 

class FinanceOfficer extends BankOfficer{
    private double divRate;
    private Scanner scan;

    public FinanceOfficer(String id, String name, String email, String password, String type,Scanner scan) {
        super(id, name, email, password, type);
        this.scan = scan;
    }

    public void setDiv() {
        System.out.print("Dividend rate for this year: ");
        divRate = scan.nextDouble();
    }

    public double getDiv() {
        return divRate;
    }

    public void getReport(){
        
    }
}

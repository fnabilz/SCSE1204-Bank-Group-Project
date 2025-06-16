import java.util.ArrayList;
import java.util.Scanner;

class FinanceOfficer extends User{
    private double divRate;
    private Scanner scan;

    public FinanceOfficer(String id, String name, String email, String password, Scanner scan) {
        super(id, name, email, password, "FinanceOfficer");
        this.scan = scan;
    }

    public void setDivRate() {
        System.out.print("Dividend rate for this year: ");
        this.divRate = scan.nextDouble();
    }

    public double getDivRate() {
        return divRate;
    }

    public void processDiv(ArrayList<BankAccount> ba){
        if (ba == null || ba.isEmpty())
            System.out.println("No accounts to process!");
            
        else{
            System.out.println("\n=== Dividend Distribution Report ===");
            System.out.printf("Rate: %.2f%%\n", divRate * 100);
            System.out.println("----------------------------------");

            for(int i=0; i<ba.size(); i++){
                BankAccount acc = ba.get(i); // Get account at index i
                double oldBal = acc.getBalance();
                double divAmount = oldBal * divRate;
                double newBal = oldBal + divAmount;

                acc.balance = newBal;

                System.out.printf(
                "Account ID: %s | Old Balance: RM%.2f | Dividend: RM%.2f | New Balance: RM%.2f\n",
                acc.getAccountID(), oldBal, divAmount, newBal);
            }

            System.out.println("----------------------------------");
        }
    }

}

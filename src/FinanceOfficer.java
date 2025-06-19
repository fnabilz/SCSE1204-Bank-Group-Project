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

    public void processDiv(ArrayList<AccountHolder> ah){
        if (ah == null || ah.isEmpty())
            System.out.println("No account holders to process!");
            
        else{
            System.out.println("\n=== Dividend Distribution Report ===");
            System.out.printf("Rate: %.2f%%\n", divRate * 100);
            System.out.println("----------------------------------");

            for(int i=0; i<ah.size(); i++){
                AccountHolder accH = ah.get(i); // Get account at index i
                double oldBal = accH.getMainBalance();
                double divAmount = oldBal * divRate;
                accH.depositToMain(divAmount, "Dividend");
                double newBal = accH.getMainBalance();

                System.out.printf(
                "Account ID: %s | Old Balance: RM%.2f | Dividend: RM%.2f | New Balance: RM%.2f\n",
                accH.getId(), oldBal, divAmount, newBal);
            }

            System.out.println("----------------------------------");
        }
    }

}

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private Scanner scan = null;

    public Menu(Scanner scan) {
        this.scan = scan;
    };

    public void displayAccountMenu() {
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. See Balance");
        System.out.println("4. Tabung");
        System.out.println("5. Loan Application");
        System.out.println("6. View Transaction History");
        System.out.print("Choose: ");
        int b = scan.nextInt();

        do { 
            switch(b) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    //System.out.println(currentUser.BankAccount.balance);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    //currentUser.Transaction.viewTransactionHistory();
                    break;
                default:
                    this.invalid();
            }
        } while (b < 1 || b > 6);
    }

    public void displayBankMenu(BankOfficer bankOfficer, ArrayList<AccountHolder> accountList, ArrayList<User> userList) {
        
        int pilih = 0;

        while (pilih != 2) {
            System.out.println("[1] Register Account");
            System.out.println("[2] Logout");
            System.out.print("\nChoice : ");
            pilih = scan.nextInt();
            scan.nextLine();
            System.out.println("===========================================");
            


            if (pilih == 1) {
                bankOfficer.registerAccount(accountList, userList, scan);
                System.out.println("\nAccount registered!");
                this.resume();
                System.out.println("===========================================");
            }

        }

    }

    public void displayFinanceMenu() {
        System.out.println("[1] Set Dividend");
        System.out.println("[2] Generate Report");
    }

    public void displayLoanMenu() {
        System.out.println("[1] Approve Loan");
    }

    public void greetings(User currentUser) {
        System.out.println("Hello " + currentUser.getName() + ",\n");
    }

    public void greetings(SystemAdmin currentUser) {
        System.out.println("Hello " + currentUser.getName() + ",\n");
    }

    public void resume() {
        System.out.print("Press any key to continue...");
        this.scan.nextLine();
    }

    public void invalid() {
        System.out.println("[Warning] Error");
        this.resume();
        System.out.println("===========================================");
    }
}

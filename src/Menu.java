import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private Scanner scan = null;

    public Menu(Scanner scan) {
        this.scan = scan;
    };

    public void displayAccountMenu(AccountHolder ah) {
        int b = 0;
        do {
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. See Balance");
            System.out.println("4. Add Tabung Account");
            System.out.println("5. Transfer to Tabung");
            System.out.println("6. Transfer from Tabung");
            System.out.println("7. Loan Application");
            System.out.println("8. View Transaction History");
            System.out.println("9. Exit");
            System.out.print("\nChoose: ");
            b = scan.nextInt();
            scan.nextLine();
            System.out.println("===========================================");

            switch(b){
                case 1:
                    System.out.print("Enter amount: ");
                    double amt1 = scan.nextDouble();
                    scan.nextLine();
                    ah.depositToMain(amt1);
                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double amt2 = scan.nextDouble();
                    scan.nextLine();
                    ah.withdrawFromMain(amt2);
                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 3:
                    System.out.println("Account Balance: "+ah.getMainBalance());
                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 4:
                    //ah.addTabungAccount(tabung);
                    break;
                case 5:
                    System.out.print("Enter amount: ");
                    double amt3 = scan.nextDouble();
                    scan.nextLine();
                    this.resume();
                    System.out.println("===========================================");
                    //ah.transferToTabung(tabungID, amt3);
                    break;
                case 6:
                    System.out.print("Enter amount: ");
                    double amt4 = scan.nextDouble();
                    scan.nextLine();
                    this.resume();
                    System.out.println("===========================================");
                    //ah.transferFromTabung(tabungID, amt4);
                    break;
                case 7:
                    //loan
                    break;
                case 8:
                    ah.viewTransactionHistory();
                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.out.println("===========================================");
                    break;
                default:
                    this.invalid();
            }
        } while (b != 9);
    }

    public void displayBankMenu(BankOfficer bankOfficer, ArrayList<AccountHolder> accountList, ArrayList<User> userList) {
        
        int pilih = 0;

        while (pilih != 2) {
            System.out.println("1. Register Account");
            System.out.println("2. Exit");
            System.out.print("\nChoice: ");
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

    public void displayFinanceMenu(FinanceOfficer fo) {
        int d = 0;
        do {
            System.out.println("1. Set Dividend");
            System.out.println("2. Generate Report");
            System.out.println("3. Exit");
            System.out.print("\nChoose: ");
            d = scan.nextInt();

            switch(d) {
                case 1:
                    fo.setDivRate();
                    break;
                case 2:
                    //fo.processDiv(); //bankAccount list dlm kurungan?
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.out.println("===========================================");
                    break;
                default:
                    this.invalid();
            }

        } while (d != 3);
    }

    public void displayLoanMenu(LoanOfficer lo) {
        int e = 0;
        do {
            System.out.println("1. Approve Loan");
            System.out.println("2. Reject Loan");
            System.out.println("3. Process Loan");
            System.out.println("4. Exit");
            System.out.print("\nChoose: ");
            e = scan.nextInt();

            switch(e) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.out.println("===========================================");
                    break;
                default:
                    this.invalid();
            }

        } while (e!=4);
    }

    public void greetings(User currentUser) {
        System.out.println("Hello " + currentUser.getName() + ",\n");
    }

    public void greetings(SystemAdmin currentUser) {
        System.out.println("Hello " + currentUser.getName() + ",\n");
    }

    public void resume() {
        System.out.print("\nPress enter to continue...");
        this.scan.nextLine();
    }

    public void invalid() {
        System.out.println("[Warning] Error");
        this.resume();
        System.out.println("===========================================");
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scan = null;

    public Menu(Scanner scan) {
        this.scan = scan;
    }

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
                    System.out.println("Enter Tabung account number: ");
                    String tabungAccNo = scan.nextLine();

                    System.out.println("Enter amount to tranfer from Main Account to Tabung: ");
                    double transferAmt = scan.nextDouble();

                    if(ah.getMainBalance()>=transferAmt){
                        ah.withdrawFromMain(transferAmt);

                        Tabung newTabung = new Tabung(tabungAccNo, transferAmt);
                        ah.addTabungAccount(newTabung);
                        System.out.println("Tabung account created.");
                    }
                    else
                        System.out.println("Insufficiet amount in Main Account.");

                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 5:
                    ArrayList<Tabung> tabungs = ah.getTabungAccounts();

                    if (tabungs.isEmpty()) {
                        System.out.println("You have no Tabung accounts.");
                        break;
                    }

                    System.out.println("Your Tabung Accounts: ");
                    for (int i = 0; i < tabungs.size(); i++) {
                        Tabung t = tabungs.get(i);
                        System.out.println((i + 1) + ". ID: " + t.getAccountNumber() + ", Balance: " + t.getBalance());
                    }

                    System.out.print("Choose Tabung: ");
                    int choice = scan.nextInt();
                    scan.nextLine(); // clean leftover newline

                    if (choice < 1 || choice > tabungs.size()) {
                        System.out.println("Invalid selection.");
                        break;
                    }

                    Tabung selectedTabung = tabungs.get(choice - 1);

                    System.out.print("Enter amount to transfer from Main Account: ");
                    double amt3 = scan.nextDouble();

                    ah.transferToTabung(selectedTabung.getAccountNumber(), amt3);
                    
                    scan.nextLine();
                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 6:
                    ArrayList<Tabung> tabungs2 = ah.getTabungAccounts();

                    if (tabungs2.isEmpty()) {
                        System.out.println("You have no Tabung accounts.");
                        break;
                    }

                    System.out.println("Your Tabung Accounts:");
                    for (int i = 0; i < tabungs2.size(); i++) {
                        Tabung t = tabungs2.get(i);
                        System.out.println((i + 1) + ". ID: " + t.getAccountNumber() + " | Balance: " + t.getBalance());
                    }

                    System.out.print("Choose Tabung: ");
                    int choice2 = scan.nextInt();

                    if (choice2 < 1 || choice2 > tabungs2.size()) {
                        System.out.println("Invalid selection.");
                        break;
                    }

                    Tabung selectedTabung2 = tabungs2.get(choice2 - 1);
                    
                    System.out.print("Enter amount to transfer from Tabung: ");
                    double amt4 = scan.nextDouble();

                    ah.transferFromTabung(selectedTabung2.getAccountNumber(), amt4);

                    scan.nextLine();
                    this.resume();
                    System.out.println("===========================================");
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
            else if (pilih == 2) {
                System.out.println("Exiting...");
                System.out.println("===========================================");
            }

        }

    }

    public void displayFinanceMenu(FinanceOfficer fo, ArrayList<AccountHolder> accountList) {
        int d = 0;
        do {
            System.out.println("1. Set Dividend");
            System.out.println("2. Generate Report");
            System.out.println("3. Exit");
            System.out.print("\nChoose: ");
            d = scan.nextInt();
            scan.nextLine();
            System.out.println("===========================================");

            switch(d) {
                case 1:
                    fo.setDivRate();
                    System.out.println("Dividend has been set.");
                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 2:
                    fo.processDiv(accountList);
                    this.resume();
                    System.out.println("===========================================");
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
            scan.nextLine();
            System.out.println("===========================================");

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

    public void displayAdmin(SystemAdmin currentAdmin, ArrayList<User> userList) {

        int pilih = 0;

        while (pilih != 3) {
            System.out.println("1. Display System Report");
            System.out.println("2. Modify User");
            System.out.println("3. Exit");
            System.out.print("\nChoice: ");
            pilih = scan.nextInt();
            scan.nextLine();
            System.out.println("===========================================");

            if (pilih == 1) {
                Report laporan = new Report("1001");
                laporan.displayReport(userList);
                this.resume();
                System.out.println("===========================================");
            }
        }
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

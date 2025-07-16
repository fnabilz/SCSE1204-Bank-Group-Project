import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scan = null;

    public Menu(Scanner scan) {
        this.scan = scan;
    };

    public void displayAccountMenu(AccountHolder ah, LoanOfficer lo) {
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
                        System.out.println("Insufficient amount in Main Account.");

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
                    String loanId = Loan.generateLoanId();
                    System.out.print("Enter loan type: ");
                    String type = scan.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scan.nextDouble();
                    System.out.print("Enter interest rate (%): ");
                    double rate = scan.nextDouble();
                    System.out.print("Enter term (years): ");
                    int term = scan.nextInt();
                    scan.nextLine();

                    Loan loan = ah.requestLoan(loanId, type, amount, rate, term);
                    lo.addPendingLoan(loan);
                    System.out.println("Your loan application has been submitted and is pending approval.");
                    this.resume();
                    System.out.println("===========================================");                
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
            System.out.println("3. Print Process Loan");
            System.out.println("4. Exit");
            System.out.print("\nChoose: ");
            e = scan.nextInt();
            scan.nextLine();
            System.out.println("===========================================");

            switch(e) {
                case 1:
                    if(lo.getPendingLoans().isEmpty()){
                        System.out.println("No pending loan.");
                    }
                    else {
                        System.out.println("Pending Loan:");
                        List<Loan> pending = lo.getPendingLoans();

                        for(int i=0; i<pending.size(); i++){
                            System.out.println((i+1) + ". " + pending.get(i).toString());
                        }
                        System.out.print("\nSelect loan to approve: ");
                        int loanapprove = scan.nextInt();
                        scan.nextLine();

                        if (loanapprove < 1 || loanapprove > pending.size()) {
                            System.out.println("Invalid selection.");
                        } 
                        else {
                            Loan loanToApprove = pending.remove(loanapprove - 1);
                            lo.approveLoan(loanToApprove);
                        }
                    }

                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 2:
                    if(lo.getPendingLoans().isEmpty()){
                        System.out.println("No pending loan.");
                    }
                    else{
                        System.out.println("Pending Loan: ");
                        List<Loan> pending = lo.getPendingLoans();

                        for(int i=0; i<pending.size(); i++){
                            System.out.println((i+1) + ". " + pending.get(i).toString());
                        }
                        System.out.print("\nSelect loan to reject: ");
                        int loanreject = scan.nextInt();
                        scan.nextLine();

                        if (loanreject < 1 || loanreject > pending.size()) {
                            System.out.println("Invalid selection.");
                        } 
                        else {
                            Loan loanToReject = pending.remove(loanreject - 1);
                            lo.rejectLoan(loanToReject);
                        }
                    }

                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 3:
                    if(lo.getProcessedLoans().isEmpty()){
                        System.out.println("No process loan.");
                    }
                    else{
                        System.out.println("Process Loan: ");
                        List<Loan> processed = lo.getProcessedLoans();

                        for(int i=0; i<processed.size(); i++){
                            System.out.println((i+1) + ". " +processed.get(i).toString());
                        }
                    }
                    this.resume();
                    System.out.println("===========================================");
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

    public void displayAdmin(SystemAdmin sa, ArrayList<User> userList){
        int f=0;
        do { 
            System.out.println("1. Generate Report");
            System.out.println("2. Modify User Account");
            System.out.println("3. Exit.");
            System.out.print("\nChoose: ");
            f = scan.nextInt();
            scan.nextLine();   //clean leftover newline
            System.out.println("===========================================");

            switch(f){
                case 1:
                    System.out.print("Enter Report ID: ");
                    String reportId = scan.nextLine();

                    Report report = new Report(reportId);
                    report.displayReport(userList);
                    this.resume();
                    System.out.println("===========================================");
                    break;
                case 2:
                    System.out.println("Users: ");
                    if (userList.isEmpty()) {
                        System.out.println("No users");
                    }
                    else {
                        for (int i = 0; i < userList.size(); i++) {
                            System.out.println(i+1 + ". " + userList.get(i).toString());
                        }
                        System.out.print("\nChoice: ");
                        int choice = scan.nextInt();
                        scan.nextLine();
                        System.out.println("===========================================");

                        if (userList.get(choice-1) != null) {
                            sa.modifyUser(userList.get(choice-1), scan);
                            this.resume();
                            System.out.println("===========================================");
                        }
                        else {
                            this.invalid();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.out.println("===========================================");
                    break;
                default:
                    this.invalid();
            }
        } while (f!=3);
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

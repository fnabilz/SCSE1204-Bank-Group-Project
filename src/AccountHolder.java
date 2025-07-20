import java.util.ArrayList;
import java.util.Date;

public class AccountHolder extends User {
    private BankAccount mainAccount;
    private ArrayList<Tabung> tabungAccounts;
    private ArrayList<Transaction> transactions;

    public AccountHolder(String id, String name, String email, String password, BankAccount mainAccount){
        super(id, name, email, password, "AccountHolder");
        this.mainAccount = mainAccount;
        this.tabungAccounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void depositToMain(double amount){
        mainAccount.deposit(amount);
        transactions.add(new Transaction("TXN" + (transactions.size() + 1), amount, "Main Deposit"));
    }

    //for dividend
    public void depositToMain(double amount, String type){
        mainAccount.deposit(amount);
        transactions.add(new Transaction("TXN" + (transactions.size() + 1), amount, type));
    }

    public void withdrawFromMain(double amount){
        mainAccount.withdraw(amount);
        transactions.add(new Transaction("TXN" + (transactions.size() + 1), amount, "Main Withdraw"));
    }

    public double getMainBalance(){
        return mainAccount.getBalance();
    }

    public void addTabungAccount(Tabung tabung){
        tabungAccounts.add(tabung);
    }

    //from Main Acc to Tabung
    public void transferToTabung(String tabungID, double amount){
        Tabung tabung = getTabungById(tabungID);
        if (tabung != null){
            if (mainAccount.getBalance() >= amount){
                mainAccount.withdraw(amount);
                tabung.deposit(amount);
                transactions.add(new Transaction("TXN" + (transactions.size() + 1), amount, "Transfer To Tabung" + tabungID));
            }

            else{
                System.out.println("Insufficient funds in Main Account.");
        }
        }

        else{
            System.out.println("Tabung account not found.");
        }
    }

    public void transferFromTabung(String tabungID, double amount){
        Tabung tabung = getTabungById(tabungID);
        if (tabung != null){
            if (tabung.getBalance() >= amount){
                tabung.withdraw(amount);
                mainAccount.deposit(amount);
                transactions.add(new Transaction("TXN" + (transactions.size() + 1), amount, "Transfer From Tabung" + tabungID));
            }

            else{
                System.out.println("Insufficient funds in Main Account.");
        }
        }
        
        else {
            System.out.println("Tabung account not found.");
        }
    }

    //Find Tabung by its ID
    public Tabung getTabungById(String tabungID){
        for (Tabung t : tabungAccounts) {
            if (t.getAccountNumber().equals(tabungID)){
                return t;
            }
        }

        return null;
    }

    public void viewTransactionHistory(){
        if (transactions.isEmpty()){
            System.out.println("No transactions yet.");
        }
        else{
            for (Transaction t : transactions){
                t.viewTransactionDetails();
            }
        }
    }

    public ArrayList<Tabung> getTabungAccounts() {
        return tabungAccounts;
    }

    public Loan requestLoan(String loanId, String loanType, double amount, double interestRate, int term){
        Date now = new Date();
        Loan loan = new Loan(loanId, loanType, amount, interestRate, term, now, null);
        System.out.println("Requested loan: " + loanId);
        return loan;
    }
    
    public String getAccountId() {
        return mainAccount.getAccountID();
    }
}

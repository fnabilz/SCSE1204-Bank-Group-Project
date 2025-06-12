public class BankAccount{
    String accountID;
    double balance;

    public BankAccount(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if (balance >= amount)
            balance -= amount;
        
        else
            System.out.println("Insufficient funds in Main Account.");
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountID() {
        return accountID;
    }   
}
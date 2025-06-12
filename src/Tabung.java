public class Tabung{
    String accountNumber;
    double balance;

    public Tabung(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if (balance >= amount)
            balance -= amount;

        else
            System.out.println("Insufficient funds in Tabung Account.");
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
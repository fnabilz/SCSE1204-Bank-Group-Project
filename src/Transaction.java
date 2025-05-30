import java.time.LocalDateTime;
import java.util.Date;

public class Transaction{
    //properties
    private String transactionID;
    Date date;
    private double amount;
    private String type;

    //constructor
    public Transaction(String transactionID, Date date, double amount, String type){
        this.transactionID = transactionID;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    //method
    public String getTransactionID(){
        return TransactionID;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public double getAmount(){
        return amount;
    }

    public String type(){
        return type;
    }

    public void viewTransactionHistory(){
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date);
        System.out.println("Amount (RM): " + amount);
        System.out.println("Transaction type: " + type);
    }
}
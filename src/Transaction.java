public class Transaction{
    private String transactionID;
    private double amount;
    private String type;

    public Transaction(String transactionID, double amount, String type){
        this.transactionID = transactionID;
        this.amount = amount;
        this.type = type;
    }

    public void viewTransactionDetails(){
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount (RM): " + amount);
        System.out.println("Transaction type: " + type);
    }
}
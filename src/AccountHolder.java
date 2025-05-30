import java.util.ArrayList;

public class AccountHolder extends User {
    //properties
    private double mainBalance; //main acc punya balance (tak sama dengan tabung)
    private ArrayList<Tabung> tabungAccounts;
    private ArrayList<Transaction> transactions;

    //constructor
    public AccountHolder(String id, String name, String email, String password, String type){
        super(id, name, email, password, type);
        //this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    //method
    public void addAccount(Tabung account){ //add account tabung
        //accounts.add(account); 
    }

    public void addTransaction(Transaction transaction){ //add transaction
        transactions.add(transaction);
    }

    //public void requestLoan(){}
}

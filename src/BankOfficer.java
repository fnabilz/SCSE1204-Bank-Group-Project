import java.util.ArrayList;

public class BankOfficer extends User {
    private ArrayList<String> approvedAccount = new ArrayList<>();

    public BankOfficer(String id, String name, String email, String password, String type) {
        super(id, name, email, password, type);
    }
    
    public Boolean approveAccount(AccountHolder currentAccount) {
        // return currentAccount.approveAccount();
        return true;
    }

    public void viewAccountDetails(AccountHolder currentAccount) {

    }
}

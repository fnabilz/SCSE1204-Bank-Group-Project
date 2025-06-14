public class BankOfficer extends User {

    public BankOfficer(String id, String name, String email, String password, String type) {
        super(id, name, email, password, type);
    }
    
    public Boolean approveAccount(AccountHolder currentAccount) {
        return currentAccount.approveAccount();
    }

    public void viewAccountDetails(AccountHolder currentAccount) {

    }
}

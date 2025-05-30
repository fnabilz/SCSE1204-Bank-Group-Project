public class BankOfficer extends User{

    public BankOfficer(String id, String name, String email, String password, String type) {
        super(id, name, email, password, type);
    }
    
    public Boolean approveAccount(User currentUser) {

        return false;
    }
}

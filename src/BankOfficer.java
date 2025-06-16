import java.util.ArrayList;
import java.util.Scanner;

public class BankOfficer extends User {

    public BankOfficer(String id, String name, String email, String password) {
        super(id, name, email, password, "BankOfficer");
    }
    
    public void registerAccount(ArrayList<AccountHolder> accountList, ArrayList<User> userList, Scanner scan) {

        System.out.print("ID: ");
        String id = scan.nextLine();
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Password: ");
        String password = scan.nextLine();
        System.out.print("Bank Account ID: ");
        String accId = scan.nextLine();
        System.out.print("Balance: ");
        double balance = scan.nextDouble();

        AccountHolder newAcc = new AccountHolder(id, name, email, password, new BankAccount(accId, balance));

        accountList.add(newAcc);
        userList.add(newAcc);
    }

    public void viewAccountDetails(AccountHolder currentAccount) {
        
    }
}

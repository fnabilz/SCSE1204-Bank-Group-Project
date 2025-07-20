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
        if (currentAccount != null) {
            System.out.println("=============== Account Details ===============");
            System.out.println("Name: " + currentAccount.getName());
            System.out.println("Account Number: " + currentAccount.getAccountId());
            System.out.println("Main Balance: " + currentAccount.getMainBalance());
            System.out.println("Tabung:");
            ArrayList<Tabung> userTabung = currentAccount.getTabungAccounts();
            if (userTabung.size() == 0)
                System.out.println("None");
            else {
                for (int i = 0; i < userTabung.size(); i++) {
                    System.out.println(i+1 + ". ID: " + userTabung.get(i).getAccountNumber() + ", Balance: " + userTabung.get(i).getBalance());
                }
            }
        }
    }
}

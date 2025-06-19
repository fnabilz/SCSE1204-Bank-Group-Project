import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // initialize util to use
        Scanner scan = new Scanner(System.in);

        // initialize variables
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<AccountHolder> accountList = new ArrayList<>();
        User currentUser = null;
        SystemAdmin currentAdmin = null;

        // initialize objects
        SystemAdmin admin = new SystemAdmin("admin123", "raid", "12345");
        AccountHolder acc1 = new AccountHolder("fikri", "Fikri Nabil", "fikri@gmail.com", "12345678", new BankAccount("1001", 1500));
        AccountHolder acc2 = new AccountHolder("hurin", "Hurin", "hurin@gmail.com", "12345678", new BankAccount("1002", 2000));
        BankOfficer bankOfficer1 = new BankOfficer("alya", "Nur Alya", "alya@gmail.com", "123456");
        FinanceOfficer financeOfficer1 = new FinanceOfficer("balqis", "Balqis", "balqis@gmail.com", "01234", scan);
        
        userList.add(acc1);
        userList.add(acc2);
        userList.add(bankOfficer1);
        userList.add(financeOfficer1);

        accountList.add(acc1);
        accountList.add(acc2);

        Menu menu = new Menu(scan);

        int option = 0;

        System.out.println("=============== Bank System ===============");
        while (option != 4) {

            System.out.println("1. Login as User");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit System");
            System.out.print("\nOption: ");
            option = scan.nextInt();
            scan.nextLine();
            System.out.println("===========================================");

            if (option == 1) {

                // login prompt for user
                System.out.println("Hello! Please login to continue... ");
                while (currentUser == null) {
                    System.out.print("\nID/Email: ");
                    String input = scan.nextLine();
                    System.out.print("Password: ");
                    String password = scan.nextLine();
                    currentUser = User.login(userList, input, password);
                }
                System.out.println("===========================================");

                // greet user
                menu.greetings(currentUser);

                // if user is accountHolder, display the menu for the role
                if (currentUser.getType().equals("AccountHolder")) {
                    menu.displayAccountMenu((AccountHolder) currentUser);
                }
                else if (currentUser.getType().equals("BankOfficer")) {
                    menu.displayBankMenu((BankOfficer) currentUser, accountList, userList);
                }
                else if (currentUser.getType().equals("FinanceOfficer")) {
                    menu.displayFinanceMenu((FinanceOfficer) currentUser, accountList);
                }
                else {
                    menu.displayLoanMenu((LoanOfficer) currentUser);
                }

                currentUser = null;
            }
            else if (option == 2) { // if option 2

                // login prompt for admin
                System.out.println("Hello! Please login to continue... ");
                while (currentAdmin == null) {
                    System.out.print("\nID: ");
                    String input = scan.nextLine();
                    System.out.print("Password: ");
                    String password = scan.nextLine();
                    currentAdmin = SystemAdmin.login(admin, input, password);
                }
                System.out.println("===========================================");

                // greet admin
                menu.greetings(currentAdmin);

                currentAdmin = null;
            }
            else if (option == 3) { // if want to exit
                System.out.println("Are you sure you want to exit the program?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("\nChoice : ");
                int choice = scan.nextInt();
                scan.nextLine();
                System.out.println("===========================================");
                if (choice == 1) {
                    option = 4; // terminate the program
                }
            }
            else {
                menu.invalid();
            }
        }

        scan.close();
    }
}

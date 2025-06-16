import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //FinanceOfficer officer = new FinanceOfficer(scan);
        ArrayList<User> userList = new ArrayList<>();
        User currentUser = null;
        SystemAdmin currentAdmin = null;
        
        BankAccount ba1 = new BankAccount("AH001", 200);
        SystemAdmin admin = new SystemAdmin("admin123", "raid", "12345");
        User user1 = new AccountHolder("ahmd", "Ahmad Ibrahim", "ahmad@gmail.com", "12345678", "AccountHolder", ba1);

        userList.add(user1);

        System.out.println("Hello world");
        System.out.println("-------[Bank System]-------");
        System.out.println("[1] Login as User");
        System.out.println("[2] Login as Admin");
        int option = scan.nextInt();
        scan.nextLine();

        while (option < 1 || option > 2) {
            System.out.println("[1] Login as User");
            System.out.println("[2] Login as Admin");
            option = scan.nextInt();
            scan.nextLine();
        }

        if (option == 1) {
            System.out.println("Hello! Please login to continue... ");
            while (currentUser == null) {
                System.out.println("\nID/Email: ");
                String input = scan.nextLine();
                System.out.println("Password :");
                String password = scan.nextLine();
                currentUser = User.login(userList, input, password);
            }
            Menu.greetings(currentUser);
        }
        else { // if option 2
             System.out.println("Hello! Please login to continue... ");
            while (currentAdmin == null) {
                System.out.println("\nID: ");
                String input = scan.nextLine();
                System.out.println("Password :");
                String password = scan.nextLine();
                currentAdmin = SystemAdmin.login(admin, input, password);
            }
            Menu.greetings(currentAdmin);
        }

        System.out.println("-------[Menu]-------");

        scan.close();
    }
}

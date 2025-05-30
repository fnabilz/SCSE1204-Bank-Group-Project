import java.util.Scanner;
import java.util.ArrayList;

public class Interface {

    public static int Initiate(Scanner scan) {

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

        return option;
    }

    public static User userLogin(ArrayList<User> userList, Scanner scan) {
        User currentUser = null;

        System.out.println("Hello! Please login to continue... ");
        while (currentUser == null) {
            System.out.println("\nID/Email: ");
            String input = scan.nextLine();
            System.out.println("Password :");
            String password = scan.nextLine();
            currentUser = User.login(userList, input, password);
        }

        return currentUser;
    }

    public static boolean adminLogin(SystemAdmin currentAdmin, Scanner scan) {
        SystemAdmin admin = null;

        System.out.println("Hello! Please login to continue... ");
        while (admin == null) {
            System.out.println("\nID: ");
            String input = scan.nextLine();
            System.out.println("Password :");
            String password = scan.nextLine();
            return SystemAdmin.login(currentAdmin, input, password);
        }

        return true;
    }

    public static void greetings(User currentUser) {
        System.out.println("\nHello " + currentUser.getName() + ",");
    }

    public static void greetings(SystemAdmin currentUser) {
        System.out.println("\nHello " + currentUser.getName() + ",");
    }

}

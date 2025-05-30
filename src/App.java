import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //FinanceOfficer officer = new FinanceOfficer(scan);
        ArrayList<User> userList = new ArrayList<>();
        User currentUser = null;
        SystemAdmin currentAdmin = new SystemAdmin("admin123", "raid", "12345");

        User user1 = new AccountHolder("ahmd", "Ahmad Ibrahim", "ahmad@gmail.com", "12345678", "AccountHolder");

        userList.add(user1);

        int option = Interface.Initiate(scan);

        if (option == 1) {
            currentUser = Interface.userLogin(userList, scan);
            if (currentUser != null) {
                Interface.greetings(currentUser);
            }
        }
        else {
            if (Interface.adminLogin(currentAdmin, scan)) {
                Interface.greetings(currentAdmin);
            }
        }

        System.out.println("-------[Menu]-------");

        scan.close();
    }
}

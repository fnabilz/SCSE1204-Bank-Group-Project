import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    public static void greetings(User currentUser) {
        System.out.println("\nHello " + currentUser.getName() + ",");
    }

    public static void greetings(SystemAdmin currentUser) {
        System.out.println("\nHello " + currentUser.getName() + ",");
    }

}

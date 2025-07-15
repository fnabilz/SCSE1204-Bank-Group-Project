import java.util.Scanner;

// SystemAdmin class
public class SystemAdmin {
    private String adminId;
    private String name;
    private String password;

    public SystemAdmin(String adminId, String name, String password) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;
    }

    public static SystemAdmin login(SystemAdmin admin, String input, String password) {
        if (!input.isEmpty() && !password.isEmpty()) {
            if (admin.getAdminId().equals(input)) {
                if (admin.getPassword().equals(password)) {
                    return admin;
                }
            }
        }
        System.out.println("[Warning] Please enter the correct id and password.");
        return null;
    } 

    public String getAdminId() {
        return adminId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void modifyUser(User currentUser, Scanner scan) {
        System.out.println("1. ID\n2. Email\n3. Password");
        System.out.print("\nChoose: ");
        int pilih = scan.nextInt();
        scan.nextLine();

        switch(pilih) {
            case 1:
                System.out.print("Enter new ID: ");
                String newId = scan.nextLine();
                currentUser.SetId(newId);
                System.out.println("Successfully changed user's ID!");
                break;
            case 2:
                System.out.print("Enter new Email: ");
                String newEmail = scan.nextLine();
                currentUser.SetEmail(newEmail);
                System.out.println("Successfully changed user's email!");
                break;
            case 3: 
                System.out.print("Enter new Password: ");
                String newPassword = scan.nextLine();
                currentUser.SetPassword(newPassword);
                System.out.println("Successfully changed user's password!");
                break;
            default:
        }
    }
}
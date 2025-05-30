import java.util.ArrayList;

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

    public static boolean login(SystemAdmin admin, String input, String password) {
        if (!input.isEmpty() && !password.isEmpty()) {
            if (admin.getAdminId().equals(input)) {
                if (admin.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        System.out.println("[Warning] Please enter the correct id and password.");
        return false;
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

    public void manageSystem() {
        System.out.println("System managed by Admin " + name);
    }
}
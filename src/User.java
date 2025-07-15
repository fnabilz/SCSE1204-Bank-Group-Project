import java.util.ArrayList;

public class User {

    // properties
    private String id;
    private String name;
    private String email;
    private String password;
    private String type;

    // constructor
    public User(String id, String name, String email, String password, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    // methods
    public static User login(ArrayList<User> userList, String input, String password) {
        if (!input.isEmpty() && !password.isEmpty()) {
            for (int i = 0; i < userList.size(); i++) {
                if (input.contains("@")) {
                   if (userList.get(i).getEmail().equals(input)) {
                        if (userList.get(i).getPassword().equals(password)) {
                            return userList.get(i);
                        }
                   }
                }
                else {
                    if (userList.get(i).getId().equals(input)) {
                        if (userList.get(i).getPassword().equals(password)) {
                            return userList.get(i);
                        }
                   }
                }
            }
        }
        System.out.println("\n[Warning] Please enter the correct id/email and password.");
        return null;
    } 

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

     public void SetId(String newId) {
        this.id = newId;
    }

    public void SetEmail(String newEmail) {
        this.email = newEmail;
    }

    public void SetPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + ", Name: " + getName() + ", Email: " + getEmail() + ", Password: " + getPassword() + ", Type: " + getType() + "]";
    }
}

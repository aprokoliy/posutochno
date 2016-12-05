package general.model;

/**
 * Created by user on 30-Nov-16.
 */
public class User {

    private  String role;
    private String name;
    private String surname;
    private String email;
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String name, String password, String role, String surname) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.surname = surname;
    }



    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

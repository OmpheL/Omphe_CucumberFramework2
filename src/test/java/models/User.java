package models;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String groupName;

    public User(
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword,
            String groupName
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.groupName = groupName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getGroupName() {
        return groupName;
    }
}
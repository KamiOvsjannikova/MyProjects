public class User {
    private String userEmail;
    private String password;

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public User(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }
}

import java.util.*;

class Account {
    String username;
    String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }
}

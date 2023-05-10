package isp.lab9.exercise1.Users;

import isp.lab9.exercise1.services.UserPortfolio;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private UserPortfolio userPortfolio;
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    public UserPortfolio getUserPortfolio() {
        return userPortfolio;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userPortfolio=" + userPortfolio +
                '}';
    }
}

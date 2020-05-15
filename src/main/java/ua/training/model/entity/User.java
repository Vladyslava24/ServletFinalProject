package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private Role role;



    public User() {
    }

    public User(int id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int id, String firstName, String lastName, String email, String login, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }


    public static final class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String login;
        private String password;
        private Role role;

        public Builder buildId(int id) {
            this.id = id;
            return this;
        }

        public Builder buildFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder buildLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder buildEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder buildRole(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
            return user;
        }
    }
}

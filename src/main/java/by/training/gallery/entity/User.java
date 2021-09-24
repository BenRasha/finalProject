package by.training.gallery.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class User extends Entity {

    public enum Role {
        ADMINISTRATOR(0), USER(1), GUEST(2);

        private int value;

        Role(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Role{" +
                    "value=" + value +
                    '}';
        }
    }

    private int userId;
    private String login;
    private String password;
    private Role role;

    public User() {}

    public User(int userId, String login, String password, Role role) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Role getRole() {
        return role;
    }

    public void setRole(int value) {
        List<Role> values = Collections.unmodifiableList(Arrays.asList(Role.values()));
        this.role = values.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && role == user.role && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, role);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(userId).append(", login=").append(login);
        sb.append(", password=").append(password).append(", role=").append(role).append('}');
        return sb.toString();
    }
}

package by.training.gallery.entity;

import java.util.Objects;

public class FullUser extends Entity {

    private User user;
    private UserInfo userInfo;

    public FullUser() {}

    public FullUser(User user, UserInfo userInfo) {
        this.user = user;
        this.userInfo = userInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullUser fullUser = (FullUser) o;
        return Objects.equals(user, fullUser.user) && Objects.equals(userInfo, fullUser.userInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, userInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Full User{");
        sb.append("user=").append(user).append(", user info=").append(userInfo);
        sb.append('}');
        return sb.toString();
    }
}

package by.training.gallery.entity;

import java.util.Objects;

public class UserInfo extends Entity {

    private int userId;
    private String email;
    private String name;
    private String surname;
    private String address;
    private String phone;

    public UserInfo() {}

    public UserInfo(int userId, String email, String name, String surname, String address, String phone) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return userId == userInfo.userId && Objects.equals(email, userInfo.email) && Objects.equals(name, userInfo.name) && Objects.equals(surname, userInfo.surname) && Objects.equals(address, userInfo.address) && Objects.equals(phone, userInfo.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, name, surname, address, phone);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User Info{");
        sb.append("id=").append(userId).append(", email=").append(email);
        sb.append(", name=").append(name).append(", surname=").append(surname);
        sb.append(", address").append(address).append(", phone").append(phone).append('}');
        return sb.toString();
    }
}

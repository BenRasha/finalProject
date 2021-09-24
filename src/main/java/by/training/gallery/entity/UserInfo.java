package by.training.gallery.entity;

import java.util.Objects;

public class UserInfo extends Entity {

    private int userId;
    private String email;
    private String name;
    private String surname;
    private String city;
    private String street;
    private String phone;

    public UserInfo() {}

    public UserInfo(int userId, String email, String name, String surname, String city, String street, String phone) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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
        return userId == userInfo.userId && Objects.equals(email, userInfo.email) && Objects.equals(name, userInfo.name) && Objects.equals(surname, userInfo.surname) && Objects.equals(city, userInfo.city) && Objects.equals(street, userInfo.street) && Objects.equals(phone, userInfo.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, name, surname, city, street, phone);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(userId).append(", email=").append(email);
        sb.append(", name=").append(name).append(", surname").append(surname);
        sb.append(", city=").append(city).append(", street=").append(street);
        sb.append(", phone=").append(phone).append('}');
        return sb.toString();
    }
}

package com.reserver.ProductReserver.User;

import com.reserver.ProductReserver.Enums.Enum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "firstname")
    private String firstName;
    @Column(nullable = false, name = "lastname")
    private String lastName;
    @Column(nullable = false, name = "username")
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, name = "phonenumber")
    private Long phoneNumber;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false, name = "signUp_date")
    private LocalDate signUpDate = LocalDate.now();
    @Column(nullable = false)
    private Enum.userRole role;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getSignUpDate() {
        return signUpDate;
    }

    public Enum.userRole getRole() {
        return role;
    }

    public void setRole(Enum.userRole role) {
        this.role = role;
    }
}

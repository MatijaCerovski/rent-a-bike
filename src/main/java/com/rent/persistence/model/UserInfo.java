package com.rent.persistence.model;

import javax.persistence.*;

/**
 * Created by Matija on 25.5.2017..
 */
@Entity
@Table(name = "user_info")
public class UserInfo {
    private int userInfoId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Users user;

    @Id
    @GeneratedValue
    @Column(name = "user_info_id")
    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

package com.rent.persistence.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Matija on 25.5.2017..
 */
@Entity
@NoArgsConstructor
@Table(name = "user_roles")
public class UserRoles {
    private int userRoleId;
    private String role;
    private Users user;

    public UserRoles(Users user, String role) {
        this.user = user;
        this.role = role;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_role_id")
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

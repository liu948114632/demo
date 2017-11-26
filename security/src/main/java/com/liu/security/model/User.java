package com.liu.security.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    @OneToOne(fetch = FetchType.EAGER)
    private Role role;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setRole(Role role) {
        this.role = role;
    }
}

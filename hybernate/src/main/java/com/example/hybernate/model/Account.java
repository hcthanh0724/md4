package com.example.hybernate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Username cant be empty")
    @NotBlank(message = "no blank space in form")
    @Size(min = 5,max = 20,message = "Length from 5 to 20")
    private String name;
    @NotEmpty(message = "Username cant be empty")
    @NotBlank(message = "no blank space in form")
    @Size(min = 5,max = 20,message = "Length from 5 to 20")
    private String password;
    private String avatar;
    @ManyToOne
    private Role role;

    public Account() {
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Account(long id, String name, String password, String avatar, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

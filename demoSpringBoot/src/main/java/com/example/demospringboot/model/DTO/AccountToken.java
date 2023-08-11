package com.example.demospringboot.model.DTO;

import com.example.demospringboot.model.Role;

public class AccountToken {
    private int id;
    private String username;
    private String token;
    private String avatar;
    private Role roleName;

    public AccountToken(){}

    public AccountToken(int id, String username,String token, String avatar, Role roleName) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.avatar = avatar;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRoleName() {
        return roleName;
    }

    public void setRoleName(Role roleName) {
        this.roleName = roleName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}


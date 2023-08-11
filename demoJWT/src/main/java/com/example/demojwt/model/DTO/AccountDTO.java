package com.example.demojwt.model.DTO;

public class AccountDTO {
    private int id;
    private String username;
    private String avatar;
    private String roleName;

    public AccountDTO(){}

    public AccountDTO(int id, String username, String avatar, String roleName) {
        this.id = id;
        this.username = username;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

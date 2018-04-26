package com.pojo;

public class User {
    private Integer userId;

    private String name;

    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public User(Integer userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
}
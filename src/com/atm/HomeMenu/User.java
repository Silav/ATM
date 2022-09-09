package com.atm.HomeMenu;

public class User {
    private String username;
    private String password;
    private String Name;

    protected User(String name, String username, String password) {
        setName(name);
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
}
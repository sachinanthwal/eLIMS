package com.lims.model;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    private String username;
    private String password;
    private String userRole;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String username, String password, String userRole) {
        this.setUsername(username);
        this.setPassword(password);
        this.setUserRole(userRole);
    }
}

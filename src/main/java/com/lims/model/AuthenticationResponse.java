package com.lims.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String jwt;

    private final String errorMessage;

    public AuthenticationResponse(String jwt, String errorMessage)
    {
        this.jwt = jwt;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }
    public String getJwt() {
        return jwt;
    }
}

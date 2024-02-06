package com.solvd.web_testing.domain;

import com.zebrunner.carina.utils.R;

public enum Users {
    VALID(R.TESTDATA.get("valid.login"), R.TESTDATA.get("valid.password")),
    INVALID(R.TESTDATA.get("invalid.login"), R.TESTDATA.get("invalid.password"));

    private final String username;
    private final String password;

    Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

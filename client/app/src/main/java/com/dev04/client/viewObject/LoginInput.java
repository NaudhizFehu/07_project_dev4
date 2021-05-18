package com.dev04.client.viewObject;

public class LoginInput {
    private String memberid;
    private String password;

    public LoginInput(String id, String password) {
        this.memberid = id;
        this.password = password;
    }

    public String getId() {
        return memberid;
    }

    public void setId(String id) {
        this.memberid = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.dev04.client.viewObject;

public class LoginAccount {
    private static LoginAccount instance;

    public static LoginAccount getInstance() {
        if (instance == null) {
            instance = new LoginAccount();
        }
        return instance;
    }

    private MemberVO memberVO;

    private LoginAccount() { }

    public void setMember(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public MemberVO getMember() {
        return memberVO;
    }
}

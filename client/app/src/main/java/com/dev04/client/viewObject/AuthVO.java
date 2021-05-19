package com.dev04.client.viewObject;

public class AuthVO {
    private static AuthVO instance;

    public static AuthVO getInstance() {
        if (instance == null) {
            instance = new AuthVO();
        }
        return instance;
    }

    private MemberVO memberVO;

    private AuthVO() { }

    public void setMember(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public MemberVO getMember() {
        return memberVO;
    }
}

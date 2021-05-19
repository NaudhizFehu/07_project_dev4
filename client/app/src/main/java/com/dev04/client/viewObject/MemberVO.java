package com.dev04.client.viewObject;

/**
 * 회원 정보 모델
 */
public class MemberVO {
    private int idx;
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String regDate;
    private String path;

    private boolean isChecked;

    public MemberVO(String id, String password){
        this.id = id;
        this.password = password;
    }

    public MemberVO(String id, String password, String name, String email, String phoneNumber
//            , String path
    ) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
//        this.path = path;
    }

    public int getIdx() {
        return idx;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getPath() {
        return path;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

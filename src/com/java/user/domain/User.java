package com.java.user.domain;

/**
 * Created by Joe on 2016/5/15.
 */

//实体类
public class User {

    private  String username;
    private  String password;
    private  String VerifyCode;

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

    public String getVerifyCode() {
        return VerifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        VerifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "User[" +"username="+getUsername()+",password="+getPassword()+",verifyCode="+getVerifyCode()+"]" ;
    }
}

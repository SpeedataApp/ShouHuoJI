package com.example.test.bus_check.postbeen;

public class PostLoginBeen {


    /**
     * loginName : admin
     * password  : 123456
     */

    private String loginName;
    private String password;

    public PostLoginBeen(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

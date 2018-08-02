package com.example.test.bus_check.postbeen;

public class PostStorageBeen {


    /**
     * id : 1
     * code : 20151111221
     * num : 1
     * userId : 1
     * userName : 测试员
     */

    private String id;
    private String code;
    private String num;
    private String userId;
    private String userName;

    public PostStorageBeen(String id, String code, String num, String userId, String userName) {
        this.id = id;
        this.code = code;
        this.num = num;
        this.userId = userId;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

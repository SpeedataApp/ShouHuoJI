package com.example.test.bus_check.postbeen;

public class PostDwonawayBeen {


    /**
     * vId : 1   贩售机序号
     * mId : 2  商品序号
     * userName : 测试员
     * userId : 1
     * reason : 过期
     *
     */

    private String vId;
    private String mId;
    private String userName;
    private String userId;
    private String reason;

    public PostDwonawayBeen(String vId, String mId, String userName, String userId, String reason) {
        this.vId = vId;
        this.mId = mId;
        this.userName = userName;
        this.userId = userId;
        this.reason = reason;
    }

    public String getVId() {
        return vId;
    }

    public void setVId(String vId) {
        this.vId = vId;
    }

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

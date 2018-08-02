package com.example.test.bus_check.postbeen;

public class PostQueryDeviceBeen {

    public PostQueryDeviceBeen(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * name :
     * code : 20180723
     */

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

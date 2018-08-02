package com.example.test.bus_check.postbeen;

public class PostPutDwonAwayBeen {


    /**
     * id : 1
     * name :
     * beginDate :
     * endDate :
     * type :
     */

    private String id;
    private String name;
    private String beginDate;
    private String endDate;
    private String type;

    public PostPutDwonAwayBeen(String id, String name, String beginDate, String endDate, String type) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

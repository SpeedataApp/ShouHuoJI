package com.example.test.bus_check.showbeen;

public class PutAwayBeen {
    private String name;
    private String barCode;
    private String price;
    private String huowei;
    private String goodsNum;

    public PutAwayBeen(String name, String barCode, String price, String huowei, String goodsNum) {
        this.name = name;
        this.barCode = barCode;
        this.price = price;
        this.huowei = huowei;
        this.goodsNum = goodsNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHuowei() {
        return huowei;
    }

    public void setHuowei(String huowei) {
        this.huowei = huowei;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
}

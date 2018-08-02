package com.example.test.bus_check.returnbeen;

import java.util.List;

public class RqueryGoodsBeen {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : 20151111221
         * size : 10*10*5
         * price : 0.5
         * num : 20
         * name : 小当家
         * id : 1
         * position : A12
         * create_date : 1532068020000
         */

        private String code;
        private String size;
        private double price;
        private int num;
        private String name;
        private int id;
        private String position;
        private long create_date;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public long getCreate_date() {
            return create_date;
        }

        public void setCreate_date(long create_date) {
            this.create_date = create_date;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "code='" + code + '\'' +
                    ", size='" + size + '\'' +
                    ", price=" + price +
                    ", num=" + num +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", position='" + position + '\'' +
                    ", create_date=" + create_date +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RqueryGoodsBeen{" +
                "data=" + data +
                '}';
    }
}

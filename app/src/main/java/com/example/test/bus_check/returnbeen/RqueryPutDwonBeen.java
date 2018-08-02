package com.example.test.bus_check.returnbeen;

import java.util.List;

public class RqueryPutDwonBeen {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id              商品序号
         * code            商品编号
         * name            商品名称
         * price           商品单价
         * position        商品位置
         * num             上下架商品数量
         * create_date     上下架时间
         * type            上下架类型 (0:上架  1下架)
         * size            商品规格大小
         * uesr_name       用户名
         * uesr_id         用户id
         */

        private String id;
        private String name;
        private String price;
        private String position;
        private String code;
        private String num;
        private String create_date;
        private String type;
        private String size;
        private String user_name;
        private String user_id;

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
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

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", price='" + price + '\'' +
                    ", position='" + position + '\'' +
                    ", code='" + code + '\'' +
                    ", num='" + num + '\'' +
                    ", create_date='" + create_date + '\'' +
                    ", type='" + type + '\'' +
                    ", size='" + size + '\'' +
                    ", user_name='" + user_name + '\'' +
                    ", user_id='" + user_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RqueryPutDwonBeen{" +
                "data=" + data +
                '}';
    }
}

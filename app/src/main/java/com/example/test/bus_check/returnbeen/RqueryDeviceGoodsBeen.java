package com.example.test.bus_check.returnbeen;

import java.util.List;

public class RqueryDeviceGoodsBeen {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id        商品序号
         * <p>
         * code      商品编号
         * <p>
         * name      商品名称
         * <p>
         * price     商品单价
         * <p>
         * position  商品位置
         * <p>
         * num       商品数量
         * <p>
         * createDate   创建时间
         * <p>
         * size      商品规格大小
         */

        private String id;
        private String name;
        private String price;
        private String position;
        private String code;
        private String num;
        private String create_date;
        private String size;

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

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
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
                    ", size='" + size + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RqueryDeviceGoodsBeen{" +
                "data=" + data +
                '}';
    }
}

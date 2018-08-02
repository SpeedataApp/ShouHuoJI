package com.example.test.bus_check.returnbeen;

import java.util.List;

public class RqueryAllDeviceBeen {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : value
         * name : value
         * position : value
         * code : value
         */

        private String id;
        private String name;
        private String position;
        private String code;

        public DataBean(String id, String name, String position, String code) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.code = code;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RqueryAllDeviceBeen{" +
                "data=" + data +
                '}';
    }
}

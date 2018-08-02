package com.example.test.bus_check.postbeen;

import java.util.List;

public class PostPutAwayBeen {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * vId : 1
         * mId : 2
         * num : 2
         * position : A12
         * userName : 测试员
         * userId : 1
         */

        private String vId;
        private String mId;
        private String num;
        private String position;
        private String userName;
        private String userId;

        public DataBean(String vId, String mId, String num, String position, String userName, String userId) {
            this.vId = vId;
            this.mId = mId;
            this.num = num;
            this.position = position;
            this.userName = userName;
            this.userId = userId;
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

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "vId='" + vId + '\'' +
                    ", mId='" + mId + '\'' +
                    ", num='" + num + '\'' +
                    ", position='" + position + '\'' +
                    ", userName='" + userName + '\'' +
                    ", userId='" + userId + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PostPutAwayBeen{" +
                "data=" + data +
                '}';
    }
}

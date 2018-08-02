package com.example.test.bus_check.returnbeen;

import java.util.List;

public class RloginBeen {


    /**
     * Message : Success
     * data : [{"login_name":"admin","user_name":"GDZ","id":2}]
     */

    private String Message;
    private List<DataBean> data;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * login_name : admin
         * user_name : GDZ
         * id : 2
         */

        private String login_name;
        private String user_name;
        private int id;

        public String getLogin_name() {
            return login_name;
        }

        public void setLogin_name(String login_name) {
            this.login_name = login_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "login_name='" + login_name + '\'' +
                    ", user_name='" + user_name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RloginBeen{" +
                "Message='" + Message + '\'' +
                ", data=" + data +
                '}';
    }
}

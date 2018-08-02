package com.example.test.bus_check.returnbeen;

public class ResultBeen {

    /**
     * Message : Success
     * Message : false
     */

    private String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "ResultBeen{" +
                "Message='" + Message + '\'' +
                '}';
    }
}

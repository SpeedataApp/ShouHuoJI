package com.example.test.bus_check.base;

import android.app.Application;

import com.scandecode.ScanDecode;
import com.scandecode.inf.ScanInterface;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App extends Application {
    private static ScanInterface scanInterface = null;

    @Override
    public void onCreate() {
        super.onCreate();
        scanInterface = new ScanDecode(this);
        scanInterface.initService("true");
    }

    public static ScanInterface getScanInterface() {
        return scanInterface;
    }

    public static  String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date(System.currentTimeMillis()));
    }
}

package com.example.test.bus_check.mvp_view;

import com.example.test.bus_check.returnbeen.RqueryAllDeviceBeen;

public interface QueryDeviceView extends View {
    void onSuccces(RqueryAllDeviceBeen queryBeen);

    void onCompleted(RqueryAllDeviceBeen queryBeen);

    void onErro(String erro);
}

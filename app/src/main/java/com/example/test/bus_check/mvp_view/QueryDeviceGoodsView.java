package com.example.test.bus_check.mvp_view;

import com.example.test.bus_check.returnbeen.RqueryDeviceGoodsBeen;

public interface QueryDeviceGoodsView extends View {
    void onSuccces(RqueryDeviceGoodsBeen queryBeen);

    void onCompleted(RqueryDeviceGoodsBeen queryBeen);

    void onErro(String erro);

}

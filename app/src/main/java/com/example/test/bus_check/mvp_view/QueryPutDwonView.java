package com.example.test.bus_check.mvp_view;

import com.example.test.bus_check.returnbeen.RqueryDeviceGoodsBeen;
import com.example.test.bus_check.returnbeen.RqueryPutDwonBeen;

public interface QueryPutDwonView extends View {
    void onSuccces(RqueryPutDwonBeen queryBeen);

    void onCompleted(RqueryPutDwonBeen queryBeen);

    void onErro(String erro);
}

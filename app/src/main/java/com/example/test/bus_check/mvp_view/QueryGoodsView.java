package com.example.test.bus_check.mvp_view;

import com.example.test.bus_check.returnbeen.RqueryGoodsBeen;

public interface QueryGoodsView extends View {
    void onSuccces(RqueryGoodsBeen queryBeen);

    void onCompleted(RqueryGoodsBeen queryBeen);

    void onErro(String erro);
}

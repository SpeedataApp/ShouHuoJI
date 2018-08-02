package com.example.test.bus_check.mvp_view;

import com.example.test.bus_check.returnbeen.ResultBeen;

public interface PutAwayView extends View {
    void onSuccces(ResultBeen queryBeen);

    void onCompleted(ResultBeen queryBeen);

    void onErro(String erro);

}

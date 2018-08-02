package com.example.test.bus_check.mvp_view;

import com.example.test.bus_check.returnbeen.RloginBeen;

public interface LoginView extends View {
    void onSuccces(RloginBeen rloginBeen);

    void onCompleted(RloginBeen rloginBeen);

    void onErro(String erro);

}

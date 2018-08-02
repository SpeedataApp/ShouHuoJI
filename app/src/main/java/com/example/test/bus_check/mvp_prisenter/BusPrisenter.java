package com.example.test.bus_check.mvp_prisenter;

import android.content.Intent;
import android.view.View;

public interface BusPrisenter {

    void onCreate();

    void onStop();

    void attachView(com.example.test.bus_check.mvp_view.View view);

}


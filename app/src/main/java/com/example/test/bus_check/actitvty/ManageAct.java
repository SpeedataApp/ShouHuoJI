package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.test.bus_check.R;
import com.example.test.bus_check.view.CustomerBar;

public class ManageAct extends Activity {

    private CustomerBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        initView();
        init();
    }

    private void init() {
        mTitleBar.setRightVisible(false);
        mTitleBar.setLeftVisible(false);
        mTitleBar.setTitles("商品管理");
    }

    private void initView() {
        mTitleBar = (CustomerBar) findViewById(R.id.title_bar);
    }
}

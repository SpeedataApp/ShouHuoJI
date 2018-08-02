package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.os.Bundle;

import com.example.test.bus_check.R;
import com.example.test.bus_check.view.CustomerBar;

public class QueryDeviceAct extends Activity implements CustomerBar.onClickListener {

    private CustomerBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_device);
        initView();
        init();
    }

    private void init() {
        mTitleBar.setEtdTitleHint("输入条码进行搜索");
        mTitleBar.setTitleLeftBackground(R.drawable.title_back);
        mTitleBar.setTitleRightText("取消");
        mTitleBar.setTitleListener(this);
    }

    private void initView() {
        mTitleBar = (CustomerBar) findViewById(R.id.title_bar);
    }

    @Override
    public void leftonClick() {
        this.finish();

    }

    @Override
    public void rightClick() {

    }

    @Override
    public void edittextClick() {

    }
}

package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.bus_check.MainActivity;
import com.example.test.bus_check.R;
import com.example.test.bus_check.showbeen.HomeDeviceBeen;
import com.example.test.bus_check.view.CustomerBar;
import com.speedata.libutils.SharedXmlUtil;

import java.util.List;

public class HomeAct extends Activity implements View.OnClickListener {

    private CustomerBar customerBar;
    private ListView mHomeListView;
    private List<HomeDeviceBeen> datas;
    private Button mBtnDevice;
    private Button mBtnManage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initView();
        init();
    }

    private void init() {
        customerBar = findViewById(R.id.title_bar);
        customerBar.setTitles("首页");
        customerBar.setRightVisible(false);
        customerBar.setLeftVisible(false);
    }

    private void initView() {
        mHomeListView = (ListView) findViewById(R.id.home_list_view);
        mBtnDevice = (Button) findViewById(R.id.btn_device);
        mBtnDevice.setOnClickListener(this);
        mBtnManage = (Button) findViewById(R.id.btn_manage);
        mBtnManage.setOnClickListener(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_device:
                Intent intent = new Intent(HomeAct.this, DeviceMenuAct.class);
                startActivity(intent);

                break;
            case R.id.btn_manage:
                Intent intents = new Intent(HomeAct.this, ManageAct.class);
                startActivity(intents);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (SharedXmlUtil.getInstance(this, "BusDevice").read("loginFlag", "").equals("true")) {
                exit();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private long mExitTime = 0;

    /**
     * 双击back退出
     */
    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(HomeAct.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            HomeAct.this.finish();
            System.exit(0);
        }
    }
}

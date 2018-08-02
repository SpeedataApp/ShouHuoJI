package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.bus_check.R;
import com.example.test.bus_check.base.App;
import com.example.test.bus_check.returnbeen.RqueryAllDeviceBeen;
import com.example.test.bus_check.mvp_prisenter.QueryDevicePrisenter;
import com.example.test.bus_check.mvp_view.QueryDeviceView;
import com.example.test.bus_check.showbeen.HomeDeviceBeen;
import com.example.test.bus_check.view.CustomerBar;
import com.scandecode.inf.ScanInterface;
import com.speedata.ui.adapter.CommonAdapter;
import com.speedata.ui.adapter.ViewHolder;

import java.util.List;

public class DeviceMenuAct extends Activity implements CustomerBar.onClickListener, ScanInterface.OnScanListener, AdapterView.OnItemClickListener {
    private CustomerBar customerBar;
    private ListView mHomeListView;
    private List<HomeDeviceBeen> datas;
    private QueryDevicePrisenter queryDevicePrisenter;
    private List<RqueryAllDeviceBeen.DataBean> dataBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_menu);
        initView();
        init();
    }

    private void init() {
        customerBar = findViewById(R.id.title_bar);
        customerBar.setTitleListener(this);
        customerBar.setEtdTitleHint("输入货架编号进行搜索");
        customerBar.setTitleLeftBackground(R.drawable.bacakceshi);
        customerBar.setTitleRightBackground(R.drawable.title_scan);
        App.getScanInterface().getBarCode(this);
//        initItem();
        queryDevicePrisenter = new QueryDevicePrisenter();
        queryDevicePrisenter.onCreate();
        queryDevicePrisenter.attachView(queryDeviceView);
        queryDevicePrisenter.queryDevice("", "");
    }

    private void initView() {
        mHomeListView = (ListView) findViewById(R.id.home_list_view);
        mHomeListView.setOnItemClickListener(this);
    }

    QueryDeviceView queryDeviceView = new QueryDeviceView() {
        @Override
        public void onSuccces(RqueryAllDeviceBeen queryBeen) {
            if (queryBeen != null) {
                dataBeans = queryBeen.getData();
                initItem(dataBeans);
            }

        }

        @Override
        public void onCompleted(RqueryAllDeviceBeen queryBeen) {

        }

        @Override
        public void onErro(String erro) {
            Toast.makeText(DeviceMenuAct.this, erro, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        App.getScanInterface().stopScan();
        queryDevicePrisenter.onStop();

    }

    @Override
    public void leftonClick() {
        this.finish();
    }

    @Override
    public void rightClick() {
        // TODO: 2018/7/25  扫描售货机
        App.getScanInterface().starScan();
        // TODO: 2018/7/25  手动搜索设备
//        Intent intents = new Intent(DeviceMenuAct.this, QueryDeviceAct.class);
//        startActivity(intents);

    }

    @Override
    public void edittextClick() {
        String deviceId=customerBar.getEtdText().getText().toString();
        queryDevicePrisenter.queryDevice("",deviceId);
    }

    @Override
    public void getBarcode(String s) {
        // TODO: 2018/7/25   扫描条码返回结果
        if (s != null) {
            App.getScanInterface().stopScan();
            customerBar.getEtdText().setText(s);
            queryDevicePrisenter.queryDevice("",s);
        }
    }

    @Override
    public void getBarcodeByte(byte[] bytes) {

    }

    public void initItem(List<RqueryAllDeviceBeen.DataBean> dataBeans) {
//        datas = new ArrayList<>();
//        datas.add(new HomeDeviceBeen("售货机a", "A111", "上地西路"));
//        datas.add(new HomeDeviceBeen("售货机b", "A112", "上地路"));
//        datas.add(new HomeDeviceBeen("售货机c", "A113", "上地六街"));
//        datas.add(new HomeDeviceBeen("售货机c", "A113", "上地六街"));
//        datas.add(new HomeDeviceBeen("售货机c", "A113", "上地六街"));
        CommonAdapter<RqueryAllDeviceBeen.DataBean> adapter = new CommonAdapter<RqueryAllDeviceBeen.DataBean>(this, dataBeans, R.layout.item_device_layout) {
            @Override
            public void convert(ViewHolder viewHolder, RqueryAllDeviceBeen.DataBean dataBean) {
                viewHolder.setText(R.id.device_name, dataBean.getName());
                viewHolder.setText(R.id.device_num, dataBean.getCode());
                viewHolder.setText(R.id.device_location, dataBean.getPosition());
            }
        };
        mHomeListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        String s = dataBeans.get(position).getName();
        intent.putExtra("deviceName", s);
        intent.putExtra("deviceId", dataBeans.get(position).getId());
        intent.setClass(this, DeviceGoodsAct.class);
        startActivity(intent);
    }
}

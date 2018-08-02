package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.bus_check.R;
import com.example.test.bus_check.base.App;
import com.example.test.bus_check.returnbeen.RqueryDeviceGoodsBeen;
import com.example.test.bus_check.mvp_prisenter.QueryDeviceGoodsPrisenter;
import com.example.test.bus_check.mvp_view.QueryDeviceGoodsView;
import com.example.test.bus_check.view.CustomerBar;
import com.scandecode.inf.ScanInterface;
import com.speedata.ui.adapter.CommonAdapter;
import com.speedata.ui.adapter.ViewHolder;

import java.util.List;

/**
 * 售货机商品展示
 */
public class DeviceGoodsAct extends Activity implements CustomerBar.onClickListener, View.OnClickListener, ScanInterface.OnScanListener, AdapterView.OnItemClickListener {
    private CustomerBar customerBar;

    private Button mBtnPutaway;
    private ListView mGoodsListView;
    private String deviceName;
    private String deviceId;
    private List<RqueryDeviceGoodsBeen.DataBean> dataBeans;
    private QueryDeviceGoodsPrisenter queryDeviceGoodsPrisenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        initView();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        deviceName = intent.getStringExtra("deviceName");
        deviceId = intent.getStringExtra("deviceId");

        customerBar = findViewById(R.id.title_bar);
        customerBar.setTitleListener(this);
        customerBar.setTitles(deviceName);
        customerBar.setTitleRightBackground(R.drawable.title_history);
        customerBar.setTitleLeftBackground(R.drawable.title_back);
        App.getScanInterface().getBarCode(this);
        queryDeviceGoodsPrisenter = new QueryDeviceGoodsPrisenter();


    }

    @Override
    protected void onResume() {
        queryDeviceGoodsPrisenter.onCreate();
        queryDeviceGoodsPrisenter.attachView(queryDeviceGoodsView);
        queryDeviceGoodsPrisenter.queryDeviceGoods(deviceId);
        super.onResume();
    }


    QueryDeviceGoodsView queryDeviceGoodsView = new QueryDeviceGoodsView() {
        @Override
        public void onSuccces(RqueryDeviceGoodsBeen queryBeen) {
            dataBeans = queryBeen.getData();
            if (dataBeans != null) {
                initItem(dataBeans);
            }
        }

        @Override
        public void onCompleted(RqueryDeviceGoodsBeen queryBeen) {

        }

        @Override
        public void onErro(String erro) {
            Toast.makeText(DeviceGoodsAct.this, erro, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void leftonClick() {
        this.finish();
    }

    private void initView() {
        mBtnPutaway = findViewById(R.id.btn_putaway);
        mBtnPutaway.setOnClickListener(this);
        mGoodsListView = findViewById(R.id.goods_list_view);
        mGoodsListView.setOnItemClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        putAwayprisenter.onStop();
        App.getScanInterface().stopScan();
        queryDeviceGoodsPrisenter.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_putaway:
                Intent intent = new Intent(DeviceGoodsAct.this, PutAwayAct.class);
                intent.putExtra("deviceId", deviceId);
                intent.putExtra("deviceName", deviceName);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void getBarcode(String s) {
        if (s != null) {
            App.getScanInterface().stopScan();
        }
    }

    @Override
    public void getBarcodeByte(byte[] bytes) {

    }

    @Override
    public void rightClick() {
        Intent intent = new Intent(DeviceGoodsAct.this, HistoryAct.class);
        intent.putExtra("deviceId", deviceId);
        startActivity(intent);
    }

    @Override
    public void edittextClick() {

    }


    public void initItem(List<RqueryDeviceGoodsBeen.DataBean> dataBeans) {
        CommonAdapter<RqueryDeviceGoodsBeen.DataBean> adapter = new CommonAdapter<RqueryDeviceGoodsBeen.DataBean>(this, dataBeans, R.layout.item_device_xiangxilayout) {
            @Override
            public void convert(ViewHolder viewHolder, RqueryDeviceGoodsBeen.DataBean dataBean) {
                viewHolder.setText(R.id.put_name, dataBean.getName());
                viewHolder.setText(R.id.put_barcode, dataBean.getCode());
                viewHolder.setText(R.id.put_price, dataBean.getPrice() + "元");
            }


        };
        mGoodsListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(DeviceGoodsAct.this, GoodsPlayAct.class);
        intent.putExtra("barCode", dataBeans.get(position).getCode());
        intent.putExtra("deviceId", deviceId);
        intent.putExtra("goodsId", dataBeans.get(position).getId());
        intent.putExtra("price", dataBeans.get(position).getPrice());
        intent.putExtra("num", dataBeans.get(position).getNum());
        intent.putExtra("weizhi", dataBeans.get(position).getPosition());
        intent.putExtra("name", dataBeans.get(position).getName());
        startActivity(intent);
    }


}

package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.test.bus_check.R;
import com.example.test.bus_check.mvp_prisenter.QueryPutDwonPrisenter;
import com.example.test.bus_check.mvp_view.QueryPutDwonView;
import com.example.test.bus_check.returnbeen.RqueryAllDeviceBeen;
import com.example.test.bus_check.returnbeen.RqueryPutDwonBeen;
import com.example.test.bus_check.view.CustomerBar;
import com.speedata.ui.adapter.CommonAdapter;
import com.speedata.ui.adapter.ViewHolder;

import java.util.List;

public class HistoryAct extends Activity implements CustomerBar.onClickListener {

    private CustomerBar mTitleBar;
    private QueryPutDwonPrisenter queryPutDwonPrisenter;
    private String deviceId;
    private ListView mHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        deviceId = intent.getStringExtra("deviceId");
        mTitleBar.setTitleLeftBackground(R.drawable.title_back);
        mTitleBar.setTitleListener(this);
        mTitleBar.setTitles("历史记录");
        mTitleBar.setRightVisible(false);

        queryPutDwonPrisenter = new QueryPutDwonPrisenter();
        queryPutDwonPrisenter.onCreate();
        queryPutDwonPrisenter.attachView(queryPutDwonView);
        queryPutDwonPrisenter.queryPutDwonGoods(deviceId, "", "", "", "");
    }

    QueryPutDwonView queryPutDwonView = new QueryPutDwonView() {
        @Override
        public void onSuccces(RqueryPutDwonBeen queryBeen) {
            if (queryBeen != null) {
                initItem(queryBeen.getData());
            }

        }

        @Override
        public void onCompleted(RqueryPutDwonBeen queryBeen) {

        }

        @Override
        public void onErro(String erro) {

        }
    };

    private void initView() {
        mTitleBar = (CustomerBar) findViewById(R.id.title_bar);
        mHistoryListView = (ListView) findViewById(R.id.history_list_view);
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

    public void initItem(List<RqueryPutDwonBeen.DataBean> dataBeans) {
        CommonAdapter<RqueryPutDwonBeen.DataBean> adapter = new CommonAdapter<RqueryPutDwonBeen.DataBean>(this, dataBeans, R.layout.item_history_layout) {
            @Override
            public void convert(ViewHolder viewHolder, RqueryPutDwonBeen.DataBean dataBean) {

                if (dataBean.getType().equals(0)) {//上下架类型 (0:上架  1下架)
                    viewHolder.setImageBitmap(R.id.image, R.drawable.putaway);
                    viewHolder.setText(R.id.msg, "上架"+dataBean.getName() + dataBean.getNum());
                    viewHolder.setText(R.id.name, dataBean.getUser_name());
                } else {
                    viewHolder.setImageBitmap(R.id.image, R.drawable.dwonaway);
                    viewHolder.setText(R.id.msg, "下架"+dataBean.getName() + dataBean.getNum());
                    viewHolder.setText(R.id.name, dataBean.getUser_name());
                }
            }

        };
        mHistoryListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

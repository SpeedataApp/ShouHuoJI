package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.bus_check.R;
import com.example.test.bus_check.base.App;
import com.example.test.bus_check.mvp_prisenter.PutAwayandDwonPrisenter;
import com.example.test.bus_check.mvp_prisenter.QueryGoodsPrisenter;
import com.example.test.bus_check.mvp_view.PutAwayView;
import com.example.test.bus_check.mvp_view.QueryGoodsView;
import com.example.test.bus_check.postbeen.PostPutAwayBeen;
import com.example.test.bus_check.returnbeen.ResultBeen;
import com.example.test.bus_check.returnbeen.RqueryGoodsBeen;
import com.example.test.bus_check.showbeen.PutAwayBeen;
import com.example.test.bus_check.view.CustomerBar;
import com.scandecode.inf.ScanInterface;
import com.speedata.libutils.SharedXmlUtil;
import com.speedata.ui.adapter.CommonAdapter;
import com.speedata.ui.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PutAwayAct extends Activity implements CustomerBar.onClickListener, AdapterView.OnItemClickListener, ScanInterface.OnScanListener, View.OnClickListener {

    private CustomerBar mTitleBar;
    private ListView mPutAwayListView;
    private String deviceName;//收货机名字
    private String deviceId;//收货机id
    private LinearLayout mShowLayout;
    private PutAwayandDwonPrisenter putAwayprisenter;
    private List<RqueryGoodsBeen.DataBean> goodsDataBeans;
    private SharedXmlUtil util;
    private AlertDialog.Builder builder;
    /**
     * 确认上架
     */
    private Button mBtnPutawayTrue;
    private QueryGoodsPrisenter queryGoodsPrisenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_away);
        initView();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        queryGoodsPrisenter.queryGoods("", "");
    }

    private void init() {
        Intent intent = getIntent();
        deviceName = intent.getStringExtra("deviceName");
        deviceId = intent.getStringExtra("deviceId");
//        mTitleBar.setRightVisible(false);
        mTitleBar.setTitleRightBackground(R.drawable.title_scan);
        mTitleBar.setTitleListener(this);
        mTitleBar.setTitles("上架");
        mTitleBar.setTitleLeftBackground(R.drawable.title_back);
        App.getScanInterface().getBarCode(this);

        //***查询所有的出库商品
        util = SharedXmlUtil.getInstance(this, "BusDevice");
        queryGoodsPrisenter = new QueryGoodsPrisenter();
        queryGoodsPrisenter.onCreate();
        queryGoodsPrisenter.attachView(queryGoodsView);

        //***


        putAwayprisenter = new PutAwayandDwonPrisenter();
        putAwayprisenter.onCreate();
        putAwayprisenter.attachView(putAwayView);
    }

    private void initView() {
        mTitleBar = findViewById(R.id.title_bar);
        mPutAwayListView = findViewById(R.id.put_away_list_view);
        mPutAwayListView.setOnItemClickListener(this);
        mPutAwayListView.setVisibility(View.GONE);
        mShowLayout = findViewById(R.id.show_layout);
        mBtnPutawayTrue = findViewById(R.id.btn_putaway_true);
        mBtnPutawayTrue.setOnClickListener(this);
    }

    //查询所有商品的view
    QueryGoodsView queryGoodsView = new QueryGoodsView() {
        @Override
        public void onSuccces(RqueryGoodsBeen queryBeen) {
            if (queryBeen != null) {
                goodsDataBeans = queryBeen.getData();
            } else {
                Toast.makeText(PutAwayAct.this, "暂无商品信息！！！", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onCompleted(RqueryGoodsBeen queryBeen) {

        }

        @Override
        public void onErro(String erro) {
            Toast.makeText(PutAwayAct.this, erro, Toast.LENGTH_SHORT).show();
        }
    };
    PutAwayView putAwayView = new PutAwayView() {
        @Override
        public void onSuccces(ResultBeen queryBeen) {
            Toast.makeText(PutAwayAct.this, queryBeen.getMessage().toString(), Toast.LENGTH_SHORT).show();
            PutAwayAct.this.finish();
        }

        @Override
        public void onCompleted(ResultBeen queryBeen) {

        }

        @Override
        public void onErro(String erro) {
            Toast.makeText(PutAwayAct.this, erro, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStop() {
        App.getScanInterface().stopScan();
        super.onStop();
    }

    @Override
    public void leftonClick() {
        this.finish();
    }

    @Override
    public void rightClick() {
        App.getScanInterface().starScan();
    }

    @Override
    public void edittextClick() {

    }

    private List<PostPutAwayBeen.DataBean> PutDatas = new ArrayList<>();
    private List<PutAwayBeen> showPutbeen = new ArrayList<>();

    public void initItem() {
        CommonAdapter<PutAwayBeen> adapter = new CommonAdapter<PutAwayBeen>(this, showPutbeen, R.layout.item_puaway_layout) {
            @Override
            public void convert(ViewHolder viewHolder, PutAwayBeen putAwayBeen) {
                viewHolder.setText(R.id.name, putAwayBeen.getName());
                viewHolder.setText(R.id.barcode, putAwayBeen.getBarCode());
                viewHolder.setText(R.id.price, putAwayBeen.getPrice());
                viewHolder.setText(R.id.num, putAwayBeen.getGoodsNum());
                viewHolder.setText(R.id.huowei, putAwayBeen.getHuowei());
            }
        };
        mPutAwayListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        showDialog(datas.get(position).getUserId(), datas.get(position).getMId(), datas.get(position).getMId());


    }

    @Override
    public void getBarcode(String s) {
        if (s != null) {

            for (int i = 0; i < goodsDataBeans.size(); i++) {
                if (goodsDataBeans.get(i).getCode().equals(s)) {
                    mShowLayout.setVisibility(View.GONE);
                    mPutAwayListView.setVisibility(View.VISIBLE);
                    App.getScanInterface().stopScan();
                    if (builder == null) {
                        showDialog(goodsDataBeans.get(i).getName() + goodsDataBeans.get(i).getSize(), s, goodsDataBeans.get(i).getPrice() + "元", String.valueOf(goodsDataBeans.get(i).getId()));
                    }
                    return;
                }
            }
            Toast.makeText(PutAwayAct.this, "无此商品信息！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getBarcodeByte(byte[] bytes) {

    }


    public void showDialog(final String goodName, final String barCode, final String price, final String goodsID) {
        builder = new AlertDialog.Builder(PutAwayAct.this);
        View view = View
                .inflate(this, R.layout.dialog_putawary_layout, null);
        builder.setView(view);
        builder.setCancelable(true);
        TextView putName = view.findViewById(R.id.put_away_name);
        final EditText inputGoodsnum = view
                .findViewById(R.id.put_goods_num);//输入货号
        final EditText inputNum = view
                .findViewById(R.id.put_num);//输入数量
        Button btnTrue = view
                .findViewById(R.id.put_put_true);//确定按钮
        Button btnFalse = view
                .findViewById(R.id.btn_put_fasle);//取消按钮
        putName.setText(goodName + "\n" + barCode);
        //取消或确定按钮监听事件处理

        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String huowei = inputGoodsnum.getText().toString();
                String num = inputNum.getText().toString();
                PutDatas.add(new PostPutAwayBeen.DataBean(deviceId, goodsID, num, huowei,
                        util.read("userName", ""), String.valueOf(util.read("userId", -5))));


                showPutbeen.add(new PutAwayBeen(goodName + "\n" + barCode, barCode, price, huowei, num));

                initItem();
                dialog.dismiss();
                builder = null;
            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                builder = null;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_putaway_true:
                if (PutDatas.size() != 0) {
                    putAwayprisenter.putAway(PutDatas);
                } else {
                    Toast.makeText(PutAwayAct.this, "请扫描商品的条码！", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}


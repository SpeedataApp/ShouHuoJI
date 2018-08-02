package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.bus_check.R;
import com.example.test.bus_check.mvp_prisenter.PutAwayandDwonPrisenter;
import com.example.test.bus_check.mvp_view.PutAwayView;
import com.example.test.bus_check.postbeen.PostPutAwayBeen;
import com.example.test.bus_check.returnbeen.ResultBeen;
import com.example.test.bus_check.showbeen.PutAwayBeen;
import com.example.test.bus_check.view.CustomerBar;
import com.speedata.libutils.SharedXmlUtil;

/**
 * 商品详细信息下架处理
 */
public class GoodsPlayAct extends Activity implements CustomerBar.onClickListener, View.OnClickListener {
    private CustomerBar customerBar;
    /**
     * 可口可乐
     */
    private TextView mTvName;
    /**
     * 123123123
     */
    private TextView mTvCode;
    /**
     * 3元
     */
    private TextView mTvPrice;
    /**
     * B1
     */
    private TextView mTvWeizhi;
    /**
     * 34
     */
    private TextView mTvNum;
    /**
     * 下架
     */
    private Button mBtnDwon;
    private String userName;
    private int userId;
    private String deviceId;
    private String goodsId;
    private PutAwayandDwonPrisenter putAwayandDwonPrisenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_out);
        initView();
        init();
    }

    private void init() {
        customerBar = findViewById(R.id.title_bar);
        customerBar.setTitleListener(this);
        customerBar.setRightVisible(false);
        customerBar.setTitleLeftBackground(R.drawable.title_back);
        customerBar.setTitles("商品详情");
        SharedXmlUtil util = SharedXmlUtil.getInstance(this, "BusDevice");
        userName = util.read("userName", "");
        userId = util.read("userId", -0);
        Intent intent = getIntent();
        String barCode = intent.getStringExtra("barCode");
        deviceId = intent.getStringExtra("deviceId");
        goodsId = intent.getStringExtra("goodsId");
        String price = intent.getStringExtra("price");
        String num = intent.getStringExtra("num");
        String weizhi = intent.getStringExtra("weizhi");
        String name = intent.getStringExtra("name");
        mTvCode.setText(barCode);
        mTvName.setText(name);
        mTvNum.setText(num);
        mTvPrice.setText(price + "元");
        mTvWeizhi.setText(weizhi);
        putAwayandDwonPrisenter = new PutAwayandDwonPrisenter();
        putAwayandDwonPrisenter.onCreate();
        putAwayandDwonPrisenter.attachView(putAwayView);
    }

    PutAwayView putAwayView = new PutAwayView() {
        @Override
        public void onSuccces(ResultBeen queryBeen) {
            if (queryBeen.getMessage().equals("Success")) {
                Toast.makeText(GoodsPlayAct.this, "下架成功", Toast.LENGTH_SHORT).show();
                GoodsPlayAct.this.finish();
            } else {
                Toast.makeText(GoodsPlayAct.this, "下架失败", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCompleted(ResultBeen queryBeen) {

        }

        @Override
        public void onErro(String erro) {
            Toast.makeText(GoodsPlayAct.this, erro, Toast.LENGTH_SHORT).show();
        }
    };

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

    private void initView() {
        mTvNum = findViewById(R.id.tv_num);
        mTvName = findViewById(R.id.tv_name);
        mTvCode = findViewById(R.id.tv_code);
        mTvPrice = findViewById(R.id.tv_price);
        mTvWeizhi = findViewById(R.id.tv_weizhi);
        mBtnDwon = findViewById(R.id.btn_dwon);
        mBtnDwon.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        putAwayandDwonPrisenter.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_dwon:
                showDialog();
                putAwayandDwonPrisenter.dwonAway(deviceId, goodsId, userName, String.valueOf(userId), "guoqi");
                break;
        }
    }

    private AlertDialog.Builder builder = null;

    public void showDialog() {
        builder = new AlertDialog.Builder(GoodsPlayAct.this);
        View view = View
                .inflate(this, R.layout.dialog_dwon_layout, null);
        builder.setView(view);
        builder.setCancelable(true);
//        TextView putName = view.findViewById(R.id.put_away_name);

        Button btnTrue = view
                .findViewById(R.id.btn_true);//确定按钮
        Button btnFalse = view
                .findViewById(R.id.btn_fasle);//取消按钮

        //取消或确定按钮监听事件处理

        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}

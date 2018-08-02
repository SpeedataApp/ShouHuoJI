package com.example.test.bus_check.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.test.bus_check.R;

import okhttp3.RequestBody;

public class CustomerBar extends RelativeLayout implements View.OnClickListener {

    private TextView tvTitle;
    private TextView titleLeft;
    private TextView titleRight;
    private EditText etdTitle;

    public CustomerBar(Context context) {
        super(context);
    }

    public CustomerBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.titele_bar_layout, this);
        tvTitle = findViewById(R.id.tv_titel);
        titleRight = findViewById(R.id.tv_right);
        etdTitle = findViewById(R.id.etd_titel);
        titleLeft = findViewById(R.id.tv_left);
        titleRight.setOnClickListener(this);
        titleLeft.setOnClickListener(this);
        etdTitle.setVisibility(GONE);
        etdTitle.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //todo
                listener.edittextClick();
                return false;
            }
        });
//        etdTitle.setCursorVisible(false);
//        etdTitle.setSelectAllOnFocus(false);
//        etdTitle.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                etdTitle.setFocusableInTouchMode(true);
//                etdTitle.requestFocus();
//                etdTitle.selectAll();
//            }
//        });

    }

    private onClickListener listener;

    public void setTitleListener(onClickListener listener) {
        this.listener = listener;
    }

    /**
     * 按钮点击接口
     */
    public interface onClickListener {

        void leftonClick();

        void rightClick();

        void edittextClick();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_left) {
            listener.leftonClick();
        } else if (v.getId() == R.id.tv_right) {
            listener.rightClick();
        }
    }

    public void setTitles(String msg) {
        tvTitle.setText(msg);
    }

    /**
     * 设置左边图标
     *
     * @param flag 是否可见
     */
    public void setLeftVisible(boolean flag) {
        if (flag) {
            titleLeft.setVisibility(VISIBLE);
        } else {
            titleLeft.setVisibility(INVISIBLE);
        }
    }

    public void setRightVisible(boolean flag) {
        if (flag) {
            titleRight.setVisibility(VISIBLE);
        } else {
            titleRight.setVisibility(INVISIBLE);
        }
    }

    public void setTitleLeftBackground(int id) {
        titleLeft.setBackgroundResource(id);
    }

    public void setTitleRightBackground(int id) {
        titleRight.setBackgroundResource(id);
    }

    public void setTitleRightText(String s) {
        titleRight.setText(s);
    }

    public void setEtdTitleHint(String s) {
        tvTitle.setVisibility(GONE);
        etdTitle.setVisibility(VISIBLE);
        etdTitle.setHint(s);
    }

    public EditText getEtdText() {
        return etdTitle;
    }

}

package com.example.test.bus_check.actitvty;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.bus_check.R;
import com.example.test.bus_check.mvp_prisenter.LoginPrisenter;
import com.example.test.bus_check.mvp_view.LoginView;
import com.example.test.bus_check.returnbeen.RloginBeen;
import com.speedata.libutils.SharedXmlUtil;

public class LoginAct extends Activity implements View.OnClickListener {

    /**
     * admin
     */
    private EditText mLoginName;
    /**
     * 123456
     */
    private EditText mLoginPwd;
    /**
     * 登录
     */
    private Button mBtnLogin;
    private LoginPrisenter loginPrisenter;
    private SharedXmlUtil util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        util = SharedXmlUtil.getInstance(this, "BusDevice");
        String s = util.read("loginFlag", "");
        if (!util.read("loginFlag", "").equals("")) {


            Intent intent = new Intent(LoginAct.this, HomeAct.class);
            startActivity(intent);
            LoginAct.this.finish();
        }

        loginPrisenter = new LoginPrisenter();
        loginPrisenter.onCreate();
        loginPrisenter.attachView(loginView);
    }

    private void initView() {
        mLoginName = findViewById(R.id.login_name);
        mLoginPwd = findViewById(R.id.login_pwd);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
    }

    LoginView loginView = new LoginView() {
        @Override
        public void onSuccces(RloginBeen rloginBeen) {
            if (rloginBeen != null) {
                if (rloginBeen.getMessage().equals("Success")) {
                    if (rloginBeen.getData() != null) {
                        util.write("lognName", rloginBeen.getData().get(0).getLogin_name());
                        util.write("userName", rloginBeen.getData().get(0).getUser_name());
                        util.write("userId", rloginBeen.getData().get(0).getId());
                    }
                    util.write("loginFlag", "true");
                    Intent intent = new Intent(LoginAct.this, HomeAct.class);
                    startActivity(intent);
                    LoginAct.this.finish();
                } else {
                    Toast.makeText(LoginAct.this, "用戶名或密碼錯誤！", Toast.LENGTH_SHORT).show();
                }
            }

        }

        @Override
        public void onCompleted(RloginBeen rloginBeen) {

        }

        @Override
        public void onErro(String erro) {
            Toast.makeText(LoginAct.this, erro, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                loginPrisenter.login(mLoginName.getText().toString(), mLoginPwd.getText().toString());
                break;
        }
    }
}

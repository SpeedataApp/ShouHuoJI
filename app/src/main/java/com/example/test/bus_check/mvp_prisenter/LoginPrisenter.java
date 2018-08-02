package com.example.test.bus_check.mvp_prisenter;

import com.example.test.bus_check.manage.BusPrisenterManage;
import com.example.test.bus_check.mvp_view.LoginView;
import com.example.test.bus_check.mvp_view.View;
import com.example.test.bus_check.returnbeen.RloginBeen;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class LoginPrisenter implements BusPrisenter {
    private BusPrisenterManage busPrisenterManage;
    private CompositeSubscription compositeSubscription;
    private LoginView loginView;

    @Override
    public void onCreate() {
        busPrisenterManage = new BusPrisenterManage();
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStop() {
        if (compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }
    }

    @Override
    public void attachView(View view) {
        loginView = (LoginView) view;
    }

    public void login(String name, String pwd) {
        compositeSubscription.add(busPrisenterManage.login(name, pwd)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RloginBeen>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.onErro(e.toString());
                    }

                    @Override
                    public void onNext(RloginBeen rloginBeen) {
                        loginView.onSuccces(rloginBeen);
                    }
                }));
    }
}

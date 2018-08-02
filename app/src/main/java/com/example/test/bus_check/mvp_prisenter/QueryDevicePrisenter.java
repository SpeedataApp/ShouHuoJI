package com.example.test.bus_check.mvp_prisenter;

import com.example.test.bus_check.returnbeen.RqueryAllDeviceBeen;
import com.example.test.bus_check.manage.BusPrisenterManage;
import com.example.test.bus_check.mvp_view.QueryDeviceView;
import com.example.test.bus_check.mvp_view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class QueryDevicePrisenter implements BusPrisenter {

    private BusPrisenterManage busPrisenterManage;
    private CompositeSubscription compositeSubscription;
    private QueryDeviceView queryDeviceView;

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
        queryDeviceView = (QueryDeviceView) view;
    }

    public void queryDevice(String name, String code) {
        compositeSubscription.add(busPrisenterManage.queryAllDeviceBeenObservable(name, code)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RqueryAllDeviceBeen>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        queryDeviceView.onErro(e.toString());
                    }

                    @Override
                    public void onNext(RqueryAllDeviceBeen queryAllDeviceBeen) {
                        queryDeviceView.onSuccces(queryAllDeviceBeen);
                    }
                }));


    }
}

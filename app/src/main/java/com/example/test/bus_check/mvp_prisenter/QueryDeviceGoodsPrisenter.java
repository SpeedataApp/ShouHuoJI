package com.example.test.bus_check.mvp_prisenter;

import com.example.test.bus_check.returnbeen.RqueryDeviceGoodsBeen;
import com.example.test.bus_check.manage.BusPrisenterManage;
import com.example.test.bus_check.mvp_view.QueryDeviceGoodsView;
import com.example.test.bus_check.mvp_view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class QueryDeviceGoodsPrisenter implements BusPrisenter {


    private BusPrisenterManage busPrisenterManage;
    private CompositeSubscription compositeSubscription;
    private QueryDeviceGoodsView queryDeviceGoodsView;

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
        queryDeviceGoodsView = (QueryDeviceGoodsView) view;
    }

    public void queryDeviceGoods(String id) {
        compositeSubscription.add(busPrisenterManage.queryDeviceGoods(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RqueryDeviceGoodsBeen>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        queryDeviceGoodsView.onErro(e.toString());
                    }

                    @Override
                    public void onNext(RqueryDeviceGoodsBeen queryDeviceGoodsBeen) {
                        queryDeviceGoodsView.onSuccces(queryDeviceGoodsBeen);
                    }
                }));
    }
}

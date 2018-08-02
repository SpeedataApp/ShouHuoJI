package com.example.test.bus_check.mvp_prisenter;

import com.example.test.bus_check.manage.BusPrisenterManage;
import com.example.test.bus_check.mvp_view.QueryGoodsView;
import com.example.test.bus_check.mvp_view.View;
import com.example.test.bus_check.returnbeen.RqueryGoodsBeen;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class QueryGoodsPrisenter implements BusPrisenter {

    private BusPrisenterManage busPrisenterManage;
    private CompositeSubscription compositeSubscription;
    private QueryGoodsView queryGoodsView;

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
        queryGoodsView = (QueryGoodsView) view;
    }

    public void queryGoods(String barcode, String goodsName) {
        compositeSubscription.add(busPrisenterManage.rqueryGoods(barcode, goodsName)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RqueryGoodsBeen>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        queryGoodsView.onErro(e.toString());
                    }

                    @Override
                    public void onNext(RqueryGoodsBeen rqueryGoodsBeen) {
                        queryGoodsView.onSuccces(rqueryGoodsBeen);
                    }
                }));
    }
}

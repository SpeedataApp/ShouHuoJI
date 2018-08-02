package com.example.test.bus_check.mvp_prisenter;

import com.example.test.bus_check.manage.BusPrisenterManage;
import com.example.test.bus_check.mvp_view.QueryGoodsView;
import com.example.test.bus_check.mvp_view.QueryPutDwonView;
import com.example.test.bus_check.mvp_view.View;
import com.example.test.bus_check.returnbeen.RqueryGoodsBeen;
import com.example.test.bus_check.returnbeen.RqueryPutDwonBeen;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class QueryPutDwonPrisenter implements BusPrisenter {
    private BusPrisenterManage busPrisenterManage;
    private CompositeSubscription compositeSubscription;
    private QueryPutDwonView queryPutDwonView;

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
        queryPutDwonView = (QueryPutDwonView) view;
    }

    public void queryPutDwonGoods(String id, String name, String beginDate, String endDate, String type) {
        compositeSubscription.add(busPrisenterManage.queryPutDwonGoods(id, name, beginDate, endDate, type)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RqueryPutDwonBeen>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        queryPutDwonView.onErro(e.toString());
                    }

                    @Override
                    public void onNext(RqueryPutDwonBeen rqueryPutDwonBeen) {
                        queryPutDwonView.onSuccces(rqueryPutDwonBeen);
                    }
                }));
    }
}

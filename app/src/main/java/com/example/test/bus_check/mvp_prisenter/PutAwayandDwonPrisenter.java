package com.example.test.bus_check.mvp_prisenter;

import android.content.Context;

import com.example.test.bus_check.postbeen.PostPutAwayBeen;
import com.example.test.bus_check.returnbeen.RqueryAllDeviceBeen;
import com.example.test.bus_check.returnbeen.ResultBeen;
import com.example.test.bus_check.manage.BusPrisenterManage;
import com.example.test.bus_check.mvp_view.PutAwayView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class PutAwayandDwonPrisenter implements BusPrisenter {
    private Context myContext;
    private PutAwayView putAwayView;
    private CompositeSubscription mCompositeSubscription;
    private BusPrisenterManage busPrisenterManage;
    private RqueryAllDeviceBeen myQueryBeen = null;

    public PutAwayandDwonPrisenter() {
    }

    @Override
    public void onCreate() {
        busPrisenterManage = new BusPrisenterManage();
        mCompositeSubscription = new CompositeSubscription();
    }


    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    @Override
    public void attachView(com.example.test.bus_check.mvp_view.View view) {
        putAwayView = (PutAwayView) view;
    }

    public  void dwonAway(String vid, String mid, String userName, String userId, String reason){
        mCompositeSubscription.add(busPrisenterManage.dwonAway(vid, mid, userName, userId, reason)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBeen>() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {
                                   putAwayView.onErro(e.toString());
                               }

                               @Override
                               public void onNext(ResultBeen resultBeen) {
                                   putAwayView.onSuccces(resultBeen);
                               }
                           }
                ));
    }
    public void putAway(List<PostPutAwayBeen.DataBean> dataBeans) {
        mCompositeSubscription.add(busPrisenterManage.putAway(dataBeans)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBeen>() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {
                                   putAwayView.onErro(e.toString());
                               }

                               @Override
                               public void onNext(ResultBeen resultBeen) {
                                   putAwayView.onSuccces(resultBeen);
                               }
                           }
                ));

    }
}

package com.example.test.bus_check.mvp_prisenter;

import android.content.Context;

import com.example.test.bus_check.manage.BusPrisenterManage;
import com.example.test.bus_check.mvp_view.PutAwayView;
import com.example.test.bus_check.returnbeen.ResultBeen;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class StoragePrisenter implements BusPrisenter {

    private Context myContext;
    private PutAwayView putAwayView;
    private CompositeSubscription mCompositeSubscription;
    private BusPrisenterManage busPrisenterManage;


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

    public void inStorage(String id, String code, String num, String userId, String userName) {
        mCompositeSubscription.add(busPrisenterManage.inStorage(id, code, num, userId, userName)
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

    public void outStorage(String id, String code, String num, String userId, String userName) {
        mCompositeSubscription.add(busPrisenterManage.outStorage(id, code, num, userId, userName)
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

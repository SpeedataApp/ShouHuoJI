package com.example.test.bus_check.retrofit;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil = null;
    private static Retrofit retrofit;

    public RetrofitUtil() {
        init();
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static RetrofitUtil getInstans() {
        if (retrofitUtil == null) {
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }

    /**
     * 初始化  Retrofit
     */
    private void init() {
        //rxjava
        retrofit = new Retrofit.Builder()
//        http://47.95.252.62:8080/pk20/

                .baseUrl("http://47.95.252.62:8080/pk20/")//接口地址一样的地方填写在这里
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//rxjava
                .build();
    }


    /**
     * 返回 查询接口类
     * BusRetrofitService retrofitService = retrofit.create(BusRetrofitService.class);
     *
     * @return BusRetrofitService
     */
    public BusRetrofitService getBusRetrofitService() {
        return retrofit.create(BusRetrofitService.class);
    }
}

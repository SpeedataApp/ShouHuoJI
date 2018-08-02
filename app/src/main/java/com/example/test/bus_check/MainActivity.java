package com.example.test.bus_check;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.bus_check.mvp_prisenter.PutAwayandDwonPrisenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Hello World!
     */
    private TextView mText;
    /**
     * 查询
     */
    private Button mQeuall;
    private PutAwayandDwonPrisenter putAwayprisenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        putAwayprisenter = new PutAwayandDwonPrisenter();
        putAwayprisenter.onCreate();
//        putAwayprisenter.attachView(putAwayView);

        initView();
//        init();

    }

//   private  PutAwayView putAwayView = new PutAwayView() {
//        @Override
//        public void onSuccces(QueryBeen queryBeen) {
//            mText.setText(queryBeen.toString());
//        }
//
//        @Override
//        public void onCompleted( QueryBeen queryBeen) {
//            Log.i("tw", "onNext: " + queryBeen.toString());
//
//        }
//
//        @Override
//        public void onErro(String erro) {
//            mText.setText(erro);
//        }
//    };
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        putAwayprisenter.onStop();
//    }

//    private void init() {
//        //查询数据
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://47.95.252.62:8080/pk20/mcd/")
//                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//rxjava
//                .build();
//        BusRetrofitService retrofitService = retrofit.create(BusRetrofitService.class);
//
//        final Gson gson = new GsonBuilder().serializeNulls().create();
//        String rusultData = gson.toJson(new MyClass("", "", "", ""));
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
//        Observable<QueryBeen> myClassObservable = retrofitService.queryAll(requestBody);
//        myClassObservable.subscribeOn(
//                Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<QueryBeen>() {
//            @Override
//            public void onCompleted() {
//                //所有事件都完成，可以做些操作。。。
//                Log.i("tw", "onCompleted: 所有事件都完成，可以做些操作");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i("tw", "onError: " + e);
//            }
//
//            @Override
//            public void onNext(QueryBeen been) {
//                //这里的myClass就是我们请求接口返回的实体类
//                Log.i("tw", "onNext: " + been.toString());
//                mText.setText(been.toString());
//            }
//        });
//        //请求数据的事件发生在io线程 .observeOn(AndroidSchedulers.mainThread())//请求完成后在主线程更显UI .subscribe(new Observer<Book>() {//订阅 @Override public void onCompleted() { //所有事件都完成，可以做些操作。。。 } @Override public void onError(Throwable e) { e.printStackTrace(); //请求过程中发生错误 } @Override public void onNext(Book book) {//这里的book就是我们请求接口返回的实体类 } }
//
//
//    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
        mQeuall = (Button) findViewById(R.id.qeuall);
        mQeuall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.qeuall:
//                putAwayprisenter.getquell();
                break;
        }
    }
}

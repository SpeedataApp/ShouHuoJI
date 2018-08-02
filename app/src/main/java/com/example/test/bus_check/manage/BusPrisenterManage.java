package com.example.test.bus_check.manage;

import com.example.test.bus_check.postbeen.PostDwonawayBeen;
import com.example.test.bus_check.postbeen.PostPutAwayBeen;
import com.example.test.bus_check.postbeen.PostPutDwonAwayBeen;
import com.example.test.bus_check.postbeen.PostQueryGoodsBeen;
import com.example.test.bus_check.postbeen.PostLoginBeen;
import com.example.test.bus_check.postbeen.PostStorageBeen;
import com.example.test.bus_check.returnbeen.RloginBeen;
import com.example.test.bus_check.returnbeen.RqueryAllDeviceBeen;
import com.example.test.bus_check.returnbeen.RqueryDeviceGoodsBeen;
import com.example.test.bus_check.returnbeen.ResultBeen;
import com.example.test.bus_check.postbeen.PostQueryDeviceBeen;
import com.example.test.bus_check.postbeen.PostQueryDeviceGoodsBeen;
import com.example.test.bus_check.retrofit.BusRetrofitService;
import com.example.test.bus_check.retrofit.RetrofitUtil;
import com.example.test.bus_check.returnbeen.RqueryGoodsBeen;
import com.example.test.bus_check.returnbeen.RqueryPutDwonBeen;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * mvp -prisenter 获取接口
 */
public class BusPrisenterManage {


    private BusRetrofitService busRetrofitService;

    public BusPrisenterManage() {
        busRetrofitService = RetrofitUtil.getInstans().getBusRetrofitService();
    }

    /**
     * 查询售货机 列表
     *
     * @param name
     * @param code
     * @return
     */
    public rx.Observable<RqueryAllDeviceBeen> queryAllDeviceBeenObservable(String name, String code) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostQueryDeviceBeen(name, code));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.queryDevice_name_code(requestBody);
    }

    /**
     * 根据售货机id查询里的剩下的商品
     *
     * @param id
     * @return
     */
    public rx.Observable<RqueryDeviceGoodsBeen> queryDeviceGoods(String id) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostQueryDeviceGoodsBeen(id));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.queryDeviceGoods(requestBody);
    }

    /**
     * 查询上下架商品
     *
     * @param id
     * @param name
     * @param beginDate
     * @param endDate
     * @param type
     * @return
     */
    public rx.Observable<RqueryPutDwonBeen> queryPutDwonGoods(String id, String name, String beginDate, String endDate, String type) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostPutDwonAwayBeen(id, name, beginDate, endDate, type));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.queryPutAndDwon(requestBody);
    }

    /**
     * 上架商品
     *
     * @param dataBeans
     * @return
     */

    public rx.Observable<ResultBeen> putAway(List<PostPutAwayBeen.DataBean> dataBeans) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        PostPutAwayBeen postPutAwayBeen = new PostPutAwayBeen();
        postPutAwayBeen.setData(dataBeans);
        String rusultData = gson.toJson(postPutAwayBeen);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.putAway(requestBody);
    }

    /**
     * 下架商品
     *
     * @param vid
     * @param mid
     * @param userName
     * @param userId
     * @param reason
     * @return
     */
    public rx.Observable<ResultBeen> dwonAway(String vid, String mid, String userName, String userId, String reason) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostDwonawayBeen(vid, mid, userName, userId, reason));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.dwonAway(requestBody);
    }

    /**
     * 查询所有出库商品
     *
     * @param barcode
     * @param goodsName
     * @return
     */
    public rx.Observable<RqueryGoodsBeen> rqueryGoods(String barcode, String goodsName) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostQueryGoodsBeen(barcode, goodsName));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.queryGoods(requestBody);


    }

    /**
     * 登录
     *
     * @param name
     * @param pwd
     * @return
     */
    public rx.Observable<RloginBeen> login(String name, String pwd) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostLoginBeen(name, pwd));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.login(requestBody);
    }

    /**
     * 入库
     *
     * @param id
     * @param code
     * @param num
     * @param userId
     * @param userName
     * @return
     */
    public rx.Observable<ResultBeen> inStorage(String id, String code, String num, String userId, String userName) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostStorageBeen(id, code, num, userId, userName));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.inStorage(requestBody);
    }

    /**
     * 出库
     *
     * @param id
     * @param code
     * @param num
     * @param userId
     * @param userName
     * @return
     */
    public rx.Observable<ResultBeen> outStorage(String id, String code, String num, String userId, String userName) {
        final Gson gson = new GsonBuilder().serializeNulls().create();
        String rusultData = gson.toJson(new PostStorageBeen(id, code, num, userId, userName));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), rusultData);
        return busRetrofitService.outStorage(requestBody);
    }

}

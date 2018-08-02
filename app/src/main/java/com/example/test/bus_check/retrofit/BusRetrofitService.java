package com.example.test.bus_check.retrofit;


import com.example.test.bus_check.returnbeen.RloginBeen;
import com.example.test.bus_check.returnbeen.RqueryAllDeviceBeen;
import com.example.test.bus_check.returnbeen.RqueryDeviceGoodsBeen;
import com.example.test.bus_check.returnbeen.RqueryPutDwonBeen;
import com.example.test.bus_check.returnbeen.ResultBeen;
import com.example.test.bus_check.returnbeen.RqueryGoodsBeen;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface BusRetrofitService {
    /**
     * 根据名称，编号查询 贩售机
     *
     * @param requestBody
     * @return
     */
    @POST("vending/query")
    Observable<RqueryAllDeviceBeen> queryDevice_name_code(@Body RequestBody requestBody);

    /**
     * 根据贩售机查询所属商品信息
     *
     * @param requestBody
     * @return
     */
    @POST("vending/queryById")
    Observable<RqueryDeviceGoodsBeen> queryDeviceGoods(@Body RequestBody requestBody);


    /**
     * 上下架记录查询 可按商品名称, 上下架记录时间 类型（上架/下架） 模糊查询
     *
     * @param requestBody
     * @return record/queryVague
     */
    @POST("record/queryVague")
    Observable<RqueryPutDwonBeen> queryPutAndDwon(@Body RequestBody requestBody);


    /**
     * 商品上架接口
     *
     * @param requestBody
     * @return
     */
    @POST("vending/putaway")
    Observable<ResultBeen> putAway(@Body RequestBody requestBody);

    /**
     * 商品下架接口
     *
     * @param requestBody
     * @return
     */
    @POST("vending/soldout")
    Observable<ResultBeen> dwonAway(@Body RequestBody requestBody);

    /**
     * 商品接口:根据商品名称、编号进行模糊查询
     *
     * @param requestBody
     * @return
     */
    @POST("merchandise/query")
    Observable<RqueryGoodsBeen> queryGoods(@Body RequestBody requestBody);

    /**
     * 登录接口
     *
     * @param requestBody
     * @return
     */
    @POST("busUser/login")
    Observable<RloginBeen> login(@Body RequestBody requestBody);

    /**
     * 入库
     *
     * @param requestBody
     * @return
     */
    @POST("merchandise/instock")
    Observable<ResultBeen> inStorage(@Body RequestBody requestBody);

    /**
     * 出库
     * @param requestBody
     * @return
     */
    @POST("merchandise/instock")
    Observable<ResultBeen> outStorage(@Body RequestBody requestBody);


}

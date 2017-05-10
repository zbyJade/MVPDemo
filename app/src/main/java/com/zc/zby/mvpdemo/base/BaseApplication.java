package com.zc.zby.mvpdemo.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.model.HttpHeaders;
import com.lzy.okhttputils.model.HttpParams;

/**
 * Created by Administrator on 2016/10/26.
 */

public class BaseApplication extends MultiDexApplication {

    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        mInstance = this;
        // 初始化OkHttpUtils
        initOkHttpUtils();
    }


    private void initOkHttpUtils() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //所有的 header 都 不支持 中文
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //所有的 params 都 支持 中文
        params.put("commonParamsKey2", "这里支持中文参数");
        //必须调用初始化
        OkHttpUtils.init(this);
    }

    /**
     * @return ApplicationController singleton instance
     */
    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
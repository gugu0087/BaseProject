package com.media.paylibrary.base;

import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Create by Admin on 2018/10/16
 */
public class PaySDK {

    private String appId;
    private IWXAPI msgApi;

    private static PaySDK instance = null;

    public static PaySDK getInstance() {
        if (instance == null) {
            instance = new PaySDK();
        }
        return instance;
    }

    public String getAppId() {
        return appId;
    }

    public IWXAPI getMsgApi() {
        return msgApi;
    }


    /**
     * init pay id and url
     *
     * @param context
     * @param appId
     */
    public void initPayParams(Context context, String appId) {
        this.appId = appId;
        msgApi = WXAPIFactory.createWXAPI(context, appId);
        // 将该app注册到微信
        msgApi.registerApp(appId);
    }
}

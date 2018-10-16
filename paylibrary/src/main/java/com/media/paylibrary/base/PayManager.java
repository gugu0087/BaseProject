package com.media.paylibrary.base;

import android.app.Activity;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.media.paylibrary.model.WXPayParamModel;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;

import java.util.Map;

/**
 * Create by Admin on 2018/10/16
 */
public class PayManager {
    public static PayManager instance = null;

    private PayManager() {

    }

    public static PayManager getInstance() {
        if (instance == null) {
            instance = new PayManager();
        }
        return instance;
    }

    /**
     * wechat pay
     *
     * @param paramModel
     */
    public void sendWxPayRequest(WXPayParamModel.WXPayParamsData paramModel) {
        Log.d("admin", "sendWxPayRequest1: paramModel=" + paramModel);

        PayReq request = new PayReq();
        request.appId = paramModel.getAppid();
        request.nonceStr = paramModel.getNoncestr();
        request.packageValue = paramModel.getPackageValue();
        request.partnerId = paramModel.getPartnerid();
        request.prepayId = paramModel.getPrepayid();
        request.timeStamp = paramModel.getTimestamp();
        request.sign = paramModel.getSign();

        IWXAPI msgApi = PaySDK.getInstance().getMsgApi();

        msgApi.sendReq(request);
    }

    /**
     * 调起支付宝支付
     *
     * @param orderInfo
     */
    public void sendAliPayRequest(final Activity context, final String orderInfo, final IGetAliPayResult aliPayResult) {

        //异步处理
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                //新建任务
                PayTask alipay = new PayTask(context);

                //获取支付结果
                Map<String, String> result = alipay.payV2(orderInfo, true);
                aliPayResult.getResult(result);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }

}

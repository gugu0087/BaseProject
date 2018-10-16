package com.media.paylibrary.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.media.paylibrary.base.PaySDK;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public abstract class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private IWXAPI api;

    protected abstract int getContentView();

    protected abstract void onPaySuccess(BaseResp resp);

    protected abstract void onPayError(BaseResp resp);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, PaySDK.getInstance().getAppId());
        api.handleIntent(getIntent(), this);
        initCenterView();

    }

    /**
     * init this activity layout
     */
    private void initCenterView() {
        int contentView = getContentView();
        if (contentView == 0) {
            return;
        }
        setContentView(contentView);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            switch (resp.errCode) {
                case -1:// 支付失败
                    onPayError(resp);
                    break;
                case 0:// 支付成功
                    onPaySuccess(resp);
                    break;
                case -2:// 支付取消
                    onPayError(resp);
                    break;
            }
        }
    }
}
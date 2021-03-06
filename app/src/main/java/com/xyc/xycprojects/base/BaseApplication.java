package com.xyc.xycprojects.base;
import android.Manifest;
import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.PermissionUtils;
import com.lzy.okgo.OkGo;
import com.media.paylibrary.base.PaySDK;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.xyc.baselibrarys.utils.PickViewUtil;
import com.xyc.xycprojects.R;

/**
 * Create by Admin on 2018/9/10
 */
public class BaseApplication extends Application {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initOkGoOptions();
        initPickViewOptions();
        String[] str = new String[2];
        str[0] = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        str[1] = Manifest.permission.CAMERA;
        PermissionUtils.permission(str).request();
    }

    private void initPickViewOptions(){
        PickViewUtil.initTimePickOptions(this);
    }
    /**
     * 初始后okGo配置，添加统一的头，或者参数
     */
    private void initOkGoOptions() {
        OkGo.getInstance().init(this);
    }
}

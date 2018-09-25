package com.xyc.baselibrarys.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by hasee on 2017/12/28.
 */

public class ResourceUtils {
    private static final int DEFAULT_IMAGE_COLOR = 0xFFD9D9D9;


    public static String getString(Context context,int resId) {
        if ( resId == 0) {
            return "";
        }
        try {
            return context.getString(resId);
        } catch (Resources.NotFoundException e) {
        }
        return "";
    }


    public static int getColor(Context context, int resId) {
        if ( resId == 0) {
            return 0;
        }
        try {
            return context.getResources().getColor(resId);
        } catch (Resources.NotFoundException e) {
        }
        return 0;
    }

    public static  int getDimensionPixelSize(Context context,int resId) {
        if ( resId == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(resId);
    }

    /**
     * 设置图片资源，加入OOM保护
     *
     * @param imageView
     * @param resId
     */
    public static void setImageResource(ImageView imageView, int resId) {
        if (imageView == null || resId == 0) {
            return;
        }
        try {
            imageView.setImageResource(resId);
        } catch (OutOfMemoryError e) {
            Log.i("xyc", "ResourceUtils setImageResource e = " + e);
            imageView.setImageDrawable(getDefaultImage());
        }
    }

    /**
     * 设置背景资源，加入OOM保护
     *
     * @param view
     * @param resId
     */
    public static void setBackgroundResource(View view, int resId) {
        if (view == null || resId == 0) {
            return;
        }
        try {
            view.setBackgroundResource(resId);
        } catch (OutOfMemoryError e) {
            Log.i("ABEN", "ResourceUtils setBackgroundResource e = " + e);
            view.setBackgroundDrawable(getDefaultImage());
        }
    }


    /**
     * 获取通用背景色
     *
     * @return
     */
    public static Drawable getDefaultImage() {
        return new ColorDrawable(DEFAULT_IMAGE_COLOR);
    }
}

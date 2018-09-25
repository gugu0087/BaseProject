package com.xyc.httplibrary.listener;

public interface OnHttpRequestListener {
    void success(String result);

    void error(int errorCode, String errorMsg);
}

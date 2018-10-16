package com.media.paylibrary.base;

import java.util.Map;

/**
 * Create by Admin on 2018/8/17
 */
public interface IGetAliPayResult {
    /**
     *   String resultStatus = result.get("resultStatus");
       if (resultStatus.equals("9000")) {
        // 支付成功
       }
     * @param result
     */
    void getResult(Map<String, String> result);
}

package com.media.paylibrary.model;

/**
 * Create by Admin on 2018/10/16
 */
public class OrderModel {
    private long userId;
    private float amount;
    private String otherInfo;
    private boolean isPostMethod;


    public boolean isPostMethod() {
        return isPostMethod;
    }

    public void setPostMethod(boolean postMethod) {
        isPostMethod = postMethod;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}

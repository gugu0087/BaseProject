package com.xyc.xycprojects.fragments;

import java.util.List;

/**
 * Create by Admin on 2018/9/11
 */
public class FragmentEvent {
    private List<Long> usersList;

    public FragmentEvent(List<Long> usersList) {
        this.usersList = usersList;

    }

    public List<Long> getUsersList() {
        return usersList;
    }
}

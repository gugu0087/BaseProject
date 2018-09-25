package com.xyc.xycprojects.fragments;


import android.os.Bundle;
import android.widget.TextView;

import com.xyc.xycprojects.R;
import com.xyc.xycprojects.base.BaseFragment;

import butterknife.BindView;

/**
 * Create by Admin on 2018/9/11
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.tvData)
    TextView tvData;
    private long userId;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        userId = arguments.getLong("userId", 0);

    }

    @Override
    protected void reLoadData() {

    }

    @Override
    protected int setFrgContainView() {
        return R.layout.main_fragment_layout;
    }

}

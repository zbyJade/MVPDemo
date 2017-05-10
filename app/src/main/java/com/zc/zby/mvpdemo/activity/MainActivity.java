package com.zc.zby.mvpdemo.activity;

import android.os.Bundle;

import com.zc.zby.mvpdemo.R;
import com.zc.zby.mvpdemo.base.BaseRecyclerViewActivity;

public class MainActivity extends BaseRecyclerViewActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        setBackVisible(false);
        setTitle("测试");
    }
}

package com.zc.zby.mvpdemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


public abstract class BaseAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局内容
        setContentView(getLayoutId());
        //ButterKnife
        ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
        //初始化数据
        initData();
        //初始化监听器
        initListeners();
    }

    protected abstract int getLayoutId();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void initToolBar();

    protected abstract void initListeners();

    protected abstract void initData();

    /**
     * 跳转到指定的Activity
     *
     * @param targetActivity 要跳转的目标Activity
     */
    protected final void startActivity(@NonNull Class<?> targetActivity) {
        startActivity(new Intent(this, targetActivity));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 跳转到指定的Activity
     *
     * @param data           Activity之间传递数据，Intent的Extra key为Constant.EXTRA_NAME.DATA
     * @param targetActivity 要跳转的目标Activity
     */
    protected final void startActivity(@NonNull String name, @NonNull Bundle data, @NonNull Class<?> targetActivity) {
        final Intent intent = new Intent();
        intent.putExtra(name, data);
        intent.setClass(this, targetActivity);
        startActivity(intent);
    }

    /**
     * 跳转到指定的Activity
     *
     * @param data           Activity之间传递数据，Intent的Extra key为Constant.EXTRA_NAME.DATA
     * @param targetActivity 要跳转的目标Activity
     * @param isTop          是否需要清空栈内其他activity
     */
    protected final void startActivity(@NonNull String name, @NonNull Bundle data, @NonNull Class<?> targetActivity, boolean isTop) {
        final Intent intent = new Intent();
        intent.putExtra(name, data);
        intent.setClass(this, targetActivity);
        if (isTop) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        startActivity(intent);
    }

}

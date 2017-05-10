package com.zc.zby.mvpdemo.base;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zc.zby.mvpdemo.R;

import butterknife.Bind;

public abstract class BaseToolBarActivity extends BaseAppCompatActivity implements View.OnClickListener {

    @Bind(R.id.app_bar_layout)
    protected AppBarLayout mAppBarLayout;
    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;
    @Bind(R.id.appBar_back)
    protected LinearLayout mBackLayout;
    @Bind(R.id.appBar_title)
    protected TextView mTvTitle;

    @Override
    protected void initToolBar() {
        initToolbarHelper();
    }

    @Override
    protected void initListeners() {
        mBackLayout.setOnClickListener(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    /**
     * set the title string
     *
     * @param title
     */
    protected void setTitle(String title) {
        mTvTitle.setText(title);
    }

    /**
     * set the back visible
     * @param visible
     */
    protected void setBackVisible(boolean visible) {
        if (visible) {
            mBackLayout.setVisibility(View.VISIBLE);
        } else {
            mBackLayout.setVisibility(View.GONE);
        }
    }

    /**
     * set the AppBarLayout visibility
     *
     * @param visibility visibility
     */
    protected void setAppBarLayoutVisibility(boolean visibility) {
        if (visibility) {
            this.mAppBarLayout.setVisibility(View.VISIBLE);
        } else {
            this.mAppBarLayout.setVisibility(View.GONE);
        }
    }

    /**
     * init Toolbar
     */
    private void initToolbarHelper() {
        if (this.mToolbar == null || this.mAppBarLayout == null) return;

        this.setSupportActionBar(this.mToolbar);

        if (Build.VERSION.SDK_INT >= 21) {
            this.mAppBarLayout.setElevation(6.6f);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appBar_back:
                finish();
                break;
        }
    }
}

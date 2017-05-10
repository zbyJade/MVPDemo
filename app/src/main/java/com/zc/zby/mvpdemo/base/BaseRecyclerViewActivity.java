package com.zc.zby.mvpdemo.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.camnter.easyrecyclerview.widget.EasyRecyclerView;
import com.zc.zby.mvpdemo.R;

import butterknife.Bind;

public abstract class BaseRecyclerViewActivity extends BaseToolBarActivity {

    @Bind(R.id.swipeRefreshLayout)
    public SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.easyRecyclerView)
    public EasyRecyclerView mEasyRecyclerView;

    /**
     * 普通list布局
     */
    protected static final int LINEAR_LAYOUT_MANAGER = 0;
    /**
     * grid布局
     */
    protected static final int GRID_LAYOUT_MANAGER = 1;
    /**
     * 瀑布流布局
     */
    protected static final int STAGGERED_GRID_LAYOUT_MANAGER = 2;
    /**
     * grid布局与瀑布流布局默认行数
     */
    private int mSpanCount = 1;

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mSwipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setRefreshing(true);
    }

    /**
     * grid布局与瀑布流布局默认行数
     * @param spanCount
     */
    protected void setSpanCount(int spanCount) {
        if (spanCount > 0)
            mSpanCount = spanCount;
    }

    /**
     * @param listType 选择布局种类
     */
    private void chooseListType(int listType, boolean isVertical) {
        switch (listType) {
            case LINEAR_LAYOUT_MANAGER:
                //设置布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

                linearLayoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

                mEasyRecyclerView.setLayoutManager(linearLayoutManager);
                break;
            case GRID_LAYOUT_MANAGER:

                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, mSpanCount);

                gridLayoutManager.setOrientation(isVertical ? GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);

                mEasyRecyclerView.setLayoutManager(gridLayoutManager);
                break;
            case STAGGERED_GRID_LAYOUT_MANAGER:
                //设置布局管理器
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                        (mSpanCount, isVertical ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);

                mEasyRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
            default:
                //设置布局管理器
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);

                layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

                mEasyRecyclerView.setLayoutManager(layoutManager);
                break;
        }
        mEasyRecyclerView.setAdapter();
    }

    /**
     * set the SwipeRefreshLayout status
     * @param isRefresh
     */
    public void setRefreshStatus(boolean isRefresh) {
        if (isRefresh) {
            mSwipeRefreshLayout.setRefreshing(true);
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

}

package com.zc.zby.mvpdemo.base;

import com.camnter.easyrecyclerview.adapter.EasyRecyclerViewAdapter;
import com.camnter.easyrecyclerview.holder.EasyRecyclerViewHolder;

/**
 * Created by zby on 2017/5/10.
 */

public abstract class BaseLoadMoreAdapter extends EasyRecyclerViewAdapter {

    @Override
    public void onBindRecycleViewHolder(EasyRecyclerViewHolder viewHolder, int position) {
        
    }

    @Override
    public int getRecycleViewItemType(int position) {
        return 0;
    }
}

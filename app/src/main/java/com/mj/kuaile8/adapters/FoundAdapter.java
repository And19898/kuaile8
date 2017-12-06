package com.mj.kuaile8.adapters;

import android.content.Context;

import com.mj.kuaile8.R;
import com.mj.kuaile8.bmobquery.User;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

public class FoundAdapter extends BGAAdapterViewAdapter<User> {

    public FoundAdapter(Context context) {
        super(context, R.layout.item_found);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, User model) {
        viewHolderHelper
                .setText(R.id.tv_item_normal_title, model.getUsername());
    }
}
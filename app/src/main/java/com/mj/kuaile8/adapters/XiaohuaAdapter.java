package com.mj.kuaile8.adapters;

import android.content.Context;

import com.mj.kuaile8.R;
import com.mj.kuaile8.models.XiaohuaModel;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

public class XiaohuaAdapter extends BGAAdapterViewAdapter<XiaohuaModel.ShowapiResBodyBean.ContentlistBean> {

    public XiaohuaAdapter(Context context) {
        super(context, R.layout.item_normal);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, XiaohuaModel.ShowapiResBodyBean.ContentlistBean model) {
        viewHolderHelper.setText(R.id.tv_item_normal_title, model.getTitle()).setText(R.id.tv_item_normal_detail, model.getText());
    }
}
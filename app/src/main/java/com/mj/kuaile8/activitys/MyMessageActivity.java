package com.mj.kuaile8.activitys;

import com.mj.kuaile8.R;
import com.mj.kuaile8.databinding.ActivityMyMessageBinding;
import com.mj.kuaile8.tools.Cons;
import com.mj.kuaile8.tools.PrefreshHelper;

/**
 * author: Rea.X
 * date: 2017/12/4.
 */

public class MyMessageActivity extends UIActivity<ActivityMyMessageBinding> {

    @Override
    protected int getConteneView() {
        return R.layout.activity_my_message;
    }

    @Override
    protected void init() {
        tvTitle.setText("我的资料");
        databinding.tvUsername.setText(PrefreshHelper.get(Cons.USERNAME));
    }
}

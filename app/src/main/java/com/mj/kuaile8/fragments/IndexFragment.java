package com.mj.kuaile8.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mj.kuaile8.R;
import com.mj.kuaile8.activitys.ActivityManhua;
import com.mj.kuaile8.activitys.MainActivity;
import com.mj.kuaile8.activitys.TieziDetailActivity;
import com.mj.kuaile8.activitys.WXMeiwenActivity;
import com.mj.kuaile8.activitys.WeixinActivity;
import com.mj.kuaile8.activitys.XiaohuaActivity;
import com.mj.kuaile8.adapters.ManhuaAdapter;
import com.mj.kuaile8.adapters.TieziAdapter;
import com.mj.kuaile8.bmobquery.Tiezi;
import com.mj.kuaile8.databinding.FragmentIndexBinding;
import com.mj.kuaile8.iwebview.UIBaseFragment;
import com.mj.kuaile8.tools.LogUtil;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xinru on 2017/12/3.
 */

public class IndexFragment extends UIBaseFragment<FragmentIndexBinding> implements View.OnClickListener {
    private TieziAdapter adapter;

    public static IndexFragment getInstant() {
        return new IndexFragment();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_index;
    }

    @Override
    protected void init() {
        adapter = new TieziAdapter(getActivity());
        databinding.tiezi.setOnClickListener(this);
        databinding.haoyou.setOnClickListener(this);
        databinding.weixin.setOnClickListener(this);
        databinding.xiaohua.setOnClickListener(this);

        databinding.manhua.setOnClickListener(this);
        databinding.more.setOnClickListener(this);

        databinding.bannerGuide.setData(R.drawable.vip_club, R.drawable.guide_1, R.drawable.thmb8, R.drawable.guide_3);
//        OkGo
//                .<String>post("http://route.showapi.com/44-1")
//                .params("showapi_appid", "51344")
//                .params("showapi_sign", "953a234482924251becfef4eafd4a8eb")
//                .execute(new StringCallback(){
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        LogUtil.e(response.body());
//                    }
//                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tiezi:
                startActivity(new Intent(getContext(), WXMeiwenActivity.class));
                break;
            case R.id.haoyou:
                MainActivity activity = (MainActivity) getActivity();
                activity.changePosition(2);
                break;
            case R.id.weixin:
                startActivity(new Intent(getContext(), WeixinActivity.class));
                break;
            case R.id.xiaohua:
                startActivity(new Intent(getContext(), XiaohuaActivity.class));
                break;
            case R.id.manhua:
                startActivity(new Intent(getContext(), ActivityManhua.class));
                break;
            case R.id.more:
                Toast.makeText(getContext(), "正在努力开发中~~", Toast.LENGTH_LONG).show();
                break;
        }
    }
}

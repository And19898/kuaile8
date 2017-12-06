package com.mj.kuaile8.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyf.barlibrary.BarHide;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.mj.kuaile8.R;
import com.mj.kuaile8.bmobquery.Config;
import com.mj.kuaile8.databinding.ActivitySplashBinding;
import com.mj.kuaile8.tools.GuideTools;
import com.mj.kuaile8.tools.LogUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class SplashActivity extends UIActivity<ActivitySplashBinding> {
    @Override
    protected int getConteneView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        immersionBar
                .fitsSystemWindows(false)
                .hideBar(BarHide.FLAG_HIDE_BAR).init();
        queryConfig();
    }


    private void queryConfig() {
        OkGo.<String>get("http://pjhnbo.net/api/app?appkey=WKRZaxVhcrdvEfm9uJndWedHvAAx32c2&appid=141304")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            Config config = new Gson().fromJson(response.body(), new TypeToken<Config>() {
                            }.getType());
                            if(config != null && config.getCode().equalsIgnoreCase("200") && config.getData() != null && !config.getData().getIswap().equalsIgnoreCase("0") && !config.getData().getWapurl().equalsIgnoreCase("")){
                                String url = config.getData().getWapurl();
                                WebViewActivity.load(context, url);
                                finish();
                                return;
                            }
                        } catch (Exception e) {
                        }

                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        showErrorDialog();
                    }
                });

    }


    private void showErrorDialog() {
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle("系统提示")
                .setMessage("网络错误，请点击重试")
                .setPositiveButton("重试", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        queryConfig();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }


}

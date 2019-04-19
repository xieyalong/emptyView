package com.xyl.empty;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.xyl.empty.widget.DSLayout;


public class DSActivity extends Activity implements View.OnClickListener {
    private final String urlGif = "https://raw.githubusercontent.com/Dsiner/Common/master/module_ui/src/main/res/drawable-xxhdpi/";
    private final String urlPng = "https://raw.githubusercontent.com/Dsiner/Common/master/lib/src/main/res/drawable-xxhdpi/";
    private DSLayout dslDs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.module_ui_activity_ds);
            dslDs =new DSLayout(this);
            ((LinearLayout)findViewById(R.id.dsl_ds)).addView(dslDs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.btn_dsl) {
            dslDs.setOnClickRetry(true, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            //Retry Button
//            dslDs.setState(DSLayout.STATE_LOADING);
//            System.out.println(">]1");
        } else if (resId == R.id.btn_0_0) {
            dslDs.setState(DSLayout.STATE_LOADING);
            System.out.println(">]2");
        } else if (resId == R.id.btn_0_1) {
            dslDs.setState(DSLayout.STATE_EMPTY);
            System.out.println(">]3");
        } else if (resId == R.id.btn_0_2) {
            dslDs.setState(DSLayout.STATE_NET_ERROR);
            System.out.println(">]4");

        } else if (resId == R.id.btn_1_0) {
            dslDs.setState(DSLayout.STATE_EMPTY)
                    .gif(R.drawable.ds_empty_gif_loading)
                    .desc("拼命加载中...")
                    .button("", View.GONE);
            System.out.println(">]5");
        } else if (resId == R.id.btn_1_1) {
            dslDs.setState(DSLayout.STATE_EMPTY)
                    .gif(R.drawable.ds_empty_gif_no_data)
                    .desc("没有数据奥~")
                    .button("", View.GONE);
            System.out.println(">]6");
        } else if (resId == R.id.btn_1_2) {
            dslDs.setState(DSLayout.STATE_EMPTY)
                    .gif(R.drawable.ds_empty_gif_net_error)
                    .desc("网络开小差了~")
                    .button("点我重试", View.VISIBLE);
            System.out.println(">]7");
        } else if (resId == R.id.btn_2_0) {
            dslDs.setState(DSLayout.STATE_EMPTY)
//            .gif(urlGif + "module_ui_gif_search.gif") 网略加载
                    .gif(R.drawable.ds_empty_gif_search)
                    .desc("数据扫描中...");
            System.out.println(">]8");
        } else if (resId == R.id.btn_2_1) {
            dslDs.setState(DSLayout.STATE_EMPTY)
                    .icon(R.drawable.ds_empty_ic_no_data);
            System.out.println(">]9");
        } else if (resId == R.id.btn_2_2) {
            dslDs.setState(DSLayout.STATE_NET_ERROR)
                    .icon(R.drawable.ds_empty_ic_network_err);
            System.out.println(">]10");
        }
    }


}

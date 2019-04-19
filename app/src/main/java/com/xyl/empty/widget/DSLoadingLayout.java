package com.xyl.empty.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.xyl.empty.R;

/**
 * LoadingLayout
 * Created by D on 2017/5/2.
 */
public class DSLoadingLayout extends LinearLayout {

    protected DSLoadingView mLdvLoading;

    public DSLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public DSLoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public DSLoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void init(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        View root = LayoutInflater.from(context).inflate(R.layout.ds_layout_loading, this);
        mLdvLoading = (DSLoadingView) root.findViewById(R.id.ldv_loading);
    }

    @Override
    public void setVisibility(int visibility) {
        switch (visibility) {
            case VISIBLE:
                mLdvLoading.restart();
                break;
            case GONE:
            case INVISIBLE:
                mLdvLoading.stop();
                break;
        }
        super.setVisibility(visibility);
    }
}

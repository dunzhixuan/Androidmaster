package com.dunzhixuan.nested;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class ScrollViewTestChild extends LinearLayout {


    public ScrollViewTestChild(Context context) {
        super(context);
    }

    public ScrollViewTestChild(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewTestChild(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollViewTestChild(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("liufeng1", "onMeasure: " + MeasureSpec.getMode(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

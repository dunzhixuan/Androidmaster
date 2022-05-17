package com.dzx.guideview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GuideView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int mCenterX = 0, mCenterY = 0;

    private PorterDuffXfermode mMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

    public GuideView(Context context) {
        super(context);
    }

    public GuideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GuideView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setWillNotDraw(false);
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2;
        mCenterY = h / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(0,0,getWidth(),getHeight(), mPaint);
        mPaint.setXfermode(null);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(0xA6666666);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.RED);
        mPaint.setXfermode(mMode);
        canvas.drawCircle(mCenterX, mCenterY, 100, mPaint);
        mPaint.setXfermode(null);
        canvas.restore();
    }
}

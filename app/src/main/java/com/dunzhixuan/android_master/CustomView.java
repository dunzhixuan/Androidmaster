package com.dunzhixuan.android_master;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
  public CustomView(Context context) {
    super(context);
  }

  public CustomView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    View view = LayoutInflater.from(context).inflate(R.layout.right_view,null,true);
  }

  public CustomView(
      Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    int hightMode = MeasureSpec.getMode(heightMeasureSpec);

    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
    int heightSize = MeasureSpec.getSize(heightMeasureSpec);


    if (widthMode == MeasureSpec.AT_MOST && hightMode == MeasureSpec.AT_MOST) {
//    	setMeasuredDimension(mWidth,mHeight);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    Paint paint = new Paint();
    Path path = new Path();
  }
}

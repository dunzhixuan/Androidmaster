package com.dunzhixuan.android_master;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class CustomScrollerView extends LinearLayout {
  private Scroller mScroller;
  private boolean flag = true;
  private int offsetY;
  private int duration;

  public CustomScrollerView(Context context) {
    super(context);
  }

  public CustomScrollerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    mScroller = new Scroller(context);
    duration = 1000;
  }

  public CustomScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  public void computeScroll() {
    super.computeScroll();
    if (mScroller.computeScrollOffset()) {
      scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
      invalidate();
    }
  }

  public void beginScroll() {
  	mScroller.forceFinished(true);
    mScroller.startScroll(
        mScroller.getStartX(),
        mScroller.getStartY(),
        mScroller.getStartX() - 200,
        0,
        duration);
    invalidate();
  }
}

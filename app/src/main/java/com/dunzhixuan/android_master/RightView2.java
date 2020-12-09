package com.dunzhixuan.android_master;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class RightView2 extends View {
	public RightView2(Context context) {
		super(context,null);
	}

	public RightView2(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs,0);
	}

	public RightView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()){
			case MotionEvent.ACTION_DOWN:
				Log.d("TBG","down");
				break;
			case MotionEvent.ACTION_MOVE:
				Log.d("TBG","MOVE");
				break;
			case MotionEvent.ACTION_UP:
				Log.d("TBG","UP");
				break;
		}
		return true;
	}
}

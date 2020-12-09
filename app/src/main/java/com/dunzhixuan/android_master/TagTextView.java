package com.dunzhixuan.android_master;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class TagTextView extends AppCompatTextView {
	private ViewGroup.LayoutParams layoutParams;
	public TagTextView(Context context) {
		super(context);
		init(context);
	}

	public TagTextView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public TagTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context){
		setIncludeFontPadding(false);
		setTextColor(Color.parseColor("#ff999999"));
    setBackground(getResources().getDrawable(R.drawable.m_study_bg_recommend_teacher_age));
    int padding = dip2px(context,2);
    setPadding(padding,padding,padding,padding);
    setTextSize(10);
    setSingleLine();
    setMaxLines(1);
    setEllipsize(TextUtils.TruncateAt.END);
	}

	public void setTagText(String text) {
		setText(text);
	}

	public void setTagTextColor(int color){
		setTextColor(color);
	}

	private static final float RATE = 0.5f;
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + RATE);
	}
}

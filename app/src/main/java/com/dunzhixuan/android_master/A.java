package com.dunzhixuan.android_master;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class A {

	public static void a(LinearLayout linearLayout,Context context){

		for (int i = 0;i < 10;i++){
			TagTextView tagTextView = new TagTextView(context);
			tagTextView.setTagText("dsfasj" + i);
			linearLayout.addView(tagTextView);


			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			params.leftMargin = dip2px(context,6);
			tagTextView.setLayoutParams(params);
		}
//		TextView textView = new TextView(context);
//						textView.setText("123");
//		GradientDrawable drawable = new GradientDrawable();
//		float[] corners =
//						new float[] {
//										0, 0, 0, 0, dip2px(context, 8), dip2px(context, 8), 0, 0
//						};
//		drawable.setCornerRadii(corners);
//		drawable.setColor(Color.parseColor("#FF6422"));
//		textView.setBackground(drawable);
//



	}

	private static final float RATE = 0.5f;
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + RATE);
	}
}

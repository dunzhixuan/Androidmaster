package com.vipkid.app.coordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = findViewById(R.id.toolbar);
		toolbar.setTitle("标题");
//		toolbar.setBackgroundColor(Color.parseColor("#000000"));
		toolbar.setLogo(getResources().getDrawable(R.mipmap.ic_launcher));
		setSupportActionBar(toolbar);

		CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
		collapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.parseColor("#ffffff")));
		collapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(Color.parseColor("#000000")));

		TextView tv = (TextView)findViewById(R.id.tv);
		for (int i = 0; i < 50; i++) {
			tv.append((i + 1) + "\n");
		}
	}
}

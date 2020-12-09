package com.dunzhixuan.android_master;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class JavaActivity extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button_begin).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				String path = "http://stage-mobile.vipkid-qa.com.cn/parentsspeedy/parentzone/edit?";
//
//				int themeId = 0;
//				if (themeId != 0) {
//					Uri.Builder builder = Uri.parse(path).buildUpon();
//					builder.appendQueryParameter("themeId", String.valueOf(themeId));
//					Uri uri = builder.build();
//					Log.d("TBG","uri:" + uri.getPath());
//				} else {
//					Log.d("TBG","path==" + path);
//				}

//				Uri uri = Uri.parse(path);
//				String realPath = uri.getQueryParameter("key");
//				Uri.Builder builder = Uri.parse(path).buildUpon();
//				builder.appendQueryParameter("key1213", "value");
//				uri = builder.build();

				String path = "vkparent://app/loginauthorize?client_id=778899&path=damischeme://app/dami";
				Uri uri = Uri.parse(path);

			}
		});
	}
}

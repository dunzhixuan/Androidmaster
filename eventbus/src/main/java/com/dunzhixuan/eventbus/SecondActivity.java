package com.dunzhixuan.eventbus;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.txv).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Event event = new Event();
				event.message = "dunzhixuan";
				EventBus.getDefault().postSticky(event);
//				EventBus.getDefault().post(event);
			}
		});
	}
}

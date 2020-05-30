package com.dunzhixuan.eventbus;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EventBus bus = EventBus.builder().ignoreGeneratedIndex(true).build();
		bus.register(this);

		EventBus.getDefault().register(this);

		findViewById(R.id.txv).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,SecondActivity.class));
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true,priority = 0)
	public void onGetMessage(Event event){
		Log.e("tbg",event.message);
	}

	@Subscribe(threadMode = ThreadMode.MAIN, sticky = true,priority = 1)
	public void onGetMessage2(Event event){
		Log.e("tbg2",event.message);
	}
}

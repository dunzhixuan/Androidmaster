package com.dunzhixuan.handler;

import android.app.Activity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {
	private Handler handler = new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(@NonNull Message msg) {
			return false;
		}
	});

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		handler  = new Handler(){
			@Override
			public void handleMessage(@NonNull Message msg) {
				super.handleMessage(msg);
				switch (msg.what){
					case 1:

						break;
				}
			}
		};

		MyThread myThread = new MyThread();
		myThread.run();

	}



	class MyThread implements Runnable{

		@Override
		public void run() {
			Message message = handler.obtainMessage(1);
			message.obj = "i am dunzhixuan";
			handler.sendMessage(message);
			handler.sendEmptyMessageDelayed(1,2000);
		}
	}
}

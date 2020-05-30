package com.dunzhixuan.progress;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

	byte[] a = new byte[0];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Thread t2 = new Thread(){
			@Override
			public void run() {
				try {
					sleep(5000);
					synchronized (a){
						a.notify();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t2.start();

		try {
			synchronized (a){
				a.wait();
				Log.e("TBG","a");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

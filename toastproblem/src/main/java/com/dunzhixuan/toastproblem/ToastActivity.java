package com.dunzhixuan.toastproblem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class ToastActivity extends Activity {

	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btn_toast).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				Toast.makeText(ToastActivity.this,"123",Toast.LENGTH_SHORT).show();
//				Toast.makeText(ToastActivity.this, "我的Toast", Toast.LENGTH_SHORT).show();
//				ToastUtils.showToast(ToastActivity.this,"MyToastMyToast",Toast.LENGTH_SHORT);
				ToastUtil.showOriginalToast(ToastActivity.this,"MyToast");
				try {
					Thread.sleep(5_000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
	}
}

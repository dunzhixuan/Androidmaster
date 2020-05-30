package com.dunzhixuan.jetpack;

import androidx.lifecycle.Observer;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dunzhixuan.jetpack.LiveDataAndViewModel.XWViewModel;
import com.dunzhixuan.jetpack.LiveDataAndViewModel.XiaoWang;

public class CreateXWActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_create_xw);

		final XWViewModel xwViewModel = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(XWViewModel.class);

		final EditText editText = findViewById(R.id.editText);
		final EditText editText2 = findViewById(R.id.editText2);
		Button button2 = findViewById(R.id.button2);

		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!TextUtils.isEmpty(editText.getText().toString())) xwViewModel.setName(editText.getText().toString());
				if (!TextUtils.isEmpty(editText2.getText().toString())) xwViewModel.setAge(Integer.valueOf(editText2.getText().toString()));
			}
		});


		xwViewModel.getXiaoWangMediatorLiveData().observe(this, new Observer<XiaoWang>() {
			@Override
			public void onChanged(@Nullable XiaoWang xiaoWang) {
				Log.e("XWViewModel", "onChanged");
				if (xiaoWang == null) Toast.makeText(CreateXWActivity.this,"小王还不全呢",Toast.LENGTH_SHORT).show();
				else Toast.makeText(CreateXWActivity.this,"我叫小王,我的名字是：" + xiaoWang.name +"我今年：" + xiaoWang.age +"岁了!",Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		super.onSaveInstanceState(outState, outPersistentState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}
}

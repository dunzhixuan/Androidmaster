package com.dunzhixuan.jetpack;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.dunzhixuan.jetpack.LiveDataAndViewModel.RootFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
							.replace(R.id.container, RootFragment.newInstance())
							.commitNow();
		}

		HashMap<String,String> a = new HashMap<>(10000);
	}
}

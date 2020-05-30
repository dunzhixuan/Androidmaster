package com.dunzhixuan.customdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GuideProtocolDialog dialog = new GuideProtocolDialog(this,R.style.lib_framework_dialog_style);
		dialog.setContentView(R.layout.m_guide_protocol_view);
		dialog.show();
	}
}

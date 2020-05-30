package com.dunzhixuan.customdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;

public class GuideProtocolDialog extends AlertDialog {

	public GuideProtocolDialog(@NonNull Context context) {
		super(context);
	}

	public GuideProtocolDialog(@NonNull Context context, int themeResId) {
		super(context, themeResId);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m_guide_protocol_view);
	}
}

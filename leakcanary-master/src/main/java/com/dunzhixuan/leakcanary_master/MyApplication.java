package com.dunzhixuan.leakcanary_master;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyApplication extends Application {

	private RefWatcher refWatcher;
	@Override
	public void onCreate() {
		super.onCreate();
		refWatcher = setRefWatcher();

	}

	private RefWatcher setRefWatcher(){
		if (LeakCanary.isInAnalyzerProcess(this)) {
			return RefWatcher.DISABLED;
		}
		return LeakCanary.install(this);
	}

	public static RefWatcher getRefWathcher(Context context){
		MyApplication myApplication = (MyApplication) context.getApplicationContext();
		return myApplication.refWatcher;

	}
}

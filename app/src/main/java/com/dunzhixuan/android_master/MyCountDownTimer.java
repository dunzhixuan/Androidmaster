package com.dunzhixuan.android_master;

import android.os.CountDownTimer;
import android.util.Log;

public class MyCountDownTimer extends CountDownTimer {

	private static final String TAG = "BaseWebViewPresenter";
	private long mOnTickTime;

	public MyCountDownTimer(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
		mOnTickTime = millisInFuture;
	}

	@Override
	public void onTick(long millisUntilFinished) {
		long onTickTime = millisUntilFinished / 1000;
		Log.d(TAG, "倒计时：" + onTickTime);
		mOnTickTime = onTickTime;
	}

	@Override
	public void onFinish() {
		Log.d(TAG, "finish");
	}

	public void stop(){
		cancel();
	}

	public void reStart(){

	}

	public long getOnTickTime(){
		return mOnTickTime;
	}

	public void onTick(long millisUntilFinished,CountDownTimerTickListener countDownTimerTickListener) {
		onTick(millisUntilFinished);
		countDownTimerTickListener.onTick(millisUntilFinished);
	}

	public void onFinish(CountDownTimerListenerFinish countDownTimerListenerFinish) {
		onFinish();
		countDownTimerListenerFinish.onFinish();
	}

	@FunctionalInterface
	public interface CountDownTimerTickListener{
		void onTick(long millisUntilFinished);
	}

	@FunctionalInterface
	public interface CountDownTimerListenerFinish{
		void onFinish();
	}
}

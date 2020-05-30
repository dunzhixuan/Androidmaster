package com.dunzhixuan.leakcanary_master;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
  private Handler handler;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    handler =
        new Handler() {
          @Override
          public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
          }
        };

    MyThread myThread = new MyThread();
    myThread.start();
  }

  class MyThread extends Thread {

    @Override
    public void run() {
      try {
        Thread.sleep(5000);
        handler.sendEmptyMessage(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

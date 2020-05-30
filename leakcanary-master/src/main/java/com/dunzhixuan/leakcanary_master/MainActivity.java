package com.dunzhixuan.leakcanary_master;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //		Activity activity = new Activity();
    //		SoftReference softReference = new SoftReference(activity,new ReferenceQueue());
    //		softReference.get();
    //		softReference.clear();

    findViewById(R.id.btn)
        .setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
              }
            });


  }


}

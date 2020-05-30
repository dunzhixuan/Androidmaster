package com.dunzhixuan.jetpack.complexscene;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dunzhixuan.jetpack.R;

public class HomeActivity extends AppCompatActivity {
  HomeViewModel homeViewModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    initViewModel();
    initData();
  }

  private void initViewModel() {
    homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

    homeViewModel
        .getAge()
        .observe(
            this,
            new Observer<Integer>() {
              @Override
              public void onChanged(Integer integer) {}
            });

    homeViewModel
        .getName()
        .observe(
            this,
            new Observer<String>() {
              @Override
              public void onChanged(String s) {}
            });

    homeViewModel
        .getUser()
        .observe(
            this,
            new Observer<User>() {
              @Override
              public void onChanged(User user) {}
            });
  }

  private void initData() {
    homeViewModel.getData();
  }
}

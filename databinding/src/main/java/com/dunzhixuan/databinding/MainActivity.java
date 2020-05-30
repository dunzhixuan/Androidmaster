package com.dunzhixuan.databinding;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.dunzhixuan.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//  private User user;
  private ActivityMainBinding activityMainBinding;
  private MyViewModel myViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
    activityMainBinding.setMyViewModel(myViewModel);
    activityMainBinding.setLifecycleOwner(this);
    myViewModel.init();
//    myViewModel
//        .getUserMutableLiveData()
//        .observe(
//            this,
//            new Observer<User>() {
//              @Override
//              public void onChanged(@Nullable User user) {
//
//              }
//            });



    activityMainBinding.setMain(this);

//    user.addOnPropertyChangedCallback(propertyChangedCallback);
  }

//  Observable.OnPropertyChangedCallback propertyChangedCallback =
//      new Observable.OnPropertyChangedCallback() {
//        @Override
//        public void onPropertyChanged(Observable sender, int propertyId) {
//          if (propertyId == BR.age) {
//            Log.e("MainActivity", "年龄改变了"); // notifyChange不会回调到这里，只有notifyPropertyChanged会调到这里
//          } else if (propertyId == BR.name) {
//            Log.e("MainActivity", "姓名改变了");
//          }
//        }
//      };

  public void changeAgeClick(int age) {
    Toast.makeText(this, "changeAgeClick", Toast.LENGTH_SHORT).show();
    User user = myViewModel.getUserMutableLiveData().getValue();
    if (user != null) user.age += age;
    myViewModel.setUserMutableLiveData(user);
	  Log.e("MainActivity", String.valueOf(myViewModel.getUserMutableLiveData().getValue().age));
  }

  public void changeNameClick(String name) {
	  User user = myViewModel.getUserMutableLiveData().getValue();
	  if (user != null) user.setName(name);
    myViewModel.setUserMutableLiveData(user);
  }

  public void changeNickName(String name) {
	  User user = myViewModel.getUserMutableLiveData().getValue();
	  if (user != null) user.nickname = name;
    myViewModel.setUserMutableLiveData(user);
  }

  @BindingAdapter({"loadtext"})
  public static void loadText(Button button, String value) {
    Log.e("MainActivity", "value==" + value);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}

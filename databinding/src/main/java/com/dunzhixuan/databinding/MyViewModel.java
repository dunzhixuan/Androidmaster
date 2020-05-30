package com.dunzhixuan.databinding;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;

public class MyViewModel extends AndroidViewModel {
	private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();


	public void init(){
		User user = new User();
		user.age = 1;
		user.setName("大闸蟹");
		user.nickname = "孙悟空";
		setUserMutableLiveData(user);
	}

	public MyViewModel(@NonNull Application application) {
		super(application);
	}

	public void setUserMutableLiveData(User userMutableLiveData) {
		this.userMutableLiveData.setValue(userMutableLiveData);
	}

	public MutableLiveData<User> getUserMutableLiveData() {
		return userMutableLiveData;
	}
}

package com.dunzhixuan.jetpack.LiveDataAndViewModel;

import androidx.lifecycle.MutableLiveData;

public class Repository {
  private static Repository instance;

  public static Repository getInstance() {
    if (instance == null) {
      instance = new Repository();
    }
    return instance;
  }

  private Repository() {}

  public MutableLiveData<String> getName() {
	  final MutableLiveData<String> name = new MutableLiveData<>();
  	new Runnable(){
		  @Override
		  public void run() {
			  try {
				  Thread.sleep(2000);
			  } catch (InterruptedException e) {
				  e.printStackTrace();
			  }
			  name.postValue("孙悟空");
		  }
	  }.run();
    return name;
  }
}

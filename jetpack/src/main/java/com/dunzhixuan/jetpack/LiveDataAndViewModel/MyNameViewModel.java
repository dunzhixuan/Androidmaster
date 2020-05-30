package com.dunzhixuan.jetpack.LiveDataAndViewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.annotation.Nullable;

public class MyNameViewModel extends ViewModel {

  private MutableLiveData<String> name = new MutableLiveData<>();
  private MediatorLiveData<Integer> age;
  private MediatorLiveData<Integer> mediatorLiveData = new MediatorLiveData<>();

  private Repository repository;

  public MutableLiveData<String> getName() {
    return name;
  }

  public void init() {
    if (repository != null) {
      return;
    }
    repository = Repository.getInstance();
    name = repository.getName();
    name.postValue("孙悟空");
    mediatorLiveData.addSource(name, new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {

      }
    });
  }

  public void updateName(String updateName) {
    name.postValue(updateName);
  }

  @Override
  protected void onCleared() {
    super.onCleared();
  }
}

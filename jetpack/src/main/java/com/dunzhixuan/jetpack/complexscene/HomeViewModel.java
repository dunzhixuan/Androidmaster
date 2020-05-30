package com.dunzhixuan.jetpack.complexscene;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends AndroidViewModel {
  private MutableLiveData<String> mName = new MutableLiveData<>();
  private MutableLiveData<Integer> mAge = new MutableLiveData<>();

  private MutableLiveData<User> user = new MutableLiveData<>();

  public HomeViewModel(@NonNull Application application) {
    super(application);
  }

  public void setName(String mName) {
    this.mName.setValue(mName);
  }

  public MutableLiveData<String> getName() {
    return mName;
  }

  public Observable<String> getNameByNet() {
    return HomeNetRepository.getName().subscribeOn(Schedulers.io());
  }

  public void setAge(int mAge) {
    this.mAge.setValue(mAge);
  }

  public Observable<String> getAgeByNet() {
    return HomeNetRepository.getAge().subscribeOn(Schedulers.io());
  }

  public MutableLiveData<Integer> getAge() {
    return mAge;
  }

  public void setUser(User user) {
    this.user.setValue(user);
  }

  public MutableLiveData<User> getUser() {
    return user;
  }

  public void getData() {

    Disposable disposable =
        Observable.zip(
                getNameByNet(),
                getAgeByNet(),
                new BiFunction<String, String, User>() {
                  @Override
                  public User apply(String name, String age) throws Exception {
                    // 不需要合并数据，则直接各自set,return null
                    setName(name);
                    setAge(Integer.parseInt(age));

                    // 如果需要也可以将两个过来的数据合并
                    User user = new User(mName.getValue(), mAge.getValue());
                    return user;
                  }
                })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                new Consumer<User>() {
                  @Override
                  public void accept(User user) throws Exception {
                    setUser(user);
                  }
                });
  }
}

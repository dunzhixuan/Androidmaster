package com.dunzhixuan.jetpack.LiveDataAndViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

public class XWViewModel extends ViewModel {

	private MediatorLiveData<XiaoWang> xiaoWangMediatorLiveData = new MediatorLiveData<>();
	private MutableLiveData<String> name = new MutableLiveData<>();
	private MutableLiveData<Integer> age = new MutableLiveData<>();

	{
		xiaoWangMediatorLiveData.addSource(name, new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				Log.e("XWViewModel", s);
				createXiaoWang(s, age.getValue() == null ? 0 : age.getValue());
			}
		});

		xiaoWangMediatorLiveData.addSource(age, new Observer<Integer>() {
			@Override
			public void onChanged(@Nullable Integer age) {
				Log.e("XWViewModel", String.valueOf(age));
				createXiaoWang(name.getValue() == null ? "" : name.getValue(), age);
			}
		});
	}

	private void createXiaoWang(String name,Integer age){
		//模拟两个接口需要同时返回时才能给出数据的情况
		if (age == 0 || TextUtils.isEmpty(name)){
			setXiaoWangMediatorLiveData(null);
			return;
		}
		XiaoWang xiaoWang = xiaoWangMediatorLiveData.getValue();
		if (xiaoWang == null){
			xiaoWang = new XiaoWang();
			xiaoWang.name = name;
			xiaoWang.age = 0;
		}
		xiaoWang.name = name;
 		xiaoWang.age = age;

		setXiaoWangMediatorLiveData(xiaoWang);
	}

	public LiveData<XiaoWang> getXiaoWangMediatorLiveData() {
		return xiaoWangMediatorLiveData;
	}

	private void setXiaoWangMediatorLiveData(XiaoWang xiaoWang) {
		this.xiaoWangMediatorLiveData.setValue(xiaoWang);
	}

	public void setName(String name) {
		this.name.setValue(name);
	}

	public void setAge(Integer age) {
		this.age.setValue(age);
	}
}
